package com.tzduan.gradle

import org.aspectj.bridge.MessageHandler
import org.aspectj.tools.ajc.Main
import org.gradle.api.Plugin
import org.gradle.api.Project


class RemixApplication implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('myApplicationTask') doLast {
            println "RemixApplication"
        }

        project.android.applicationVariants.all { variant ->
            variant.javaCompile.doLast {
                if (!variant.buildType.isDebuggable()) {
                    return;
                }
                MessageHandler handler = new MessageHandler(true);
                new Main().run(AspectjCommandBuilder.commandBuild(javaCompile, project.android), handler)
                ExceptionHandle.handleMessage(handler, project.logger)
            }
        }

    }
}