package com.tzduan.gradle

import org.aspectj.bridge.MessageHandler
import org.aspectj.tools.ajc.Main
import org.gradle.api.Plugin
import org.gradle.api.Project

class RemixLibrary implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('myLibraryTask') doLast {
            println "RemixLibrary"
        }

        project.android.libraryVariants.all { variant ->
            variant.javaCompile.doLast {
                MessageHandler handler = new MessageHandler(true);
                new Main().run(AspectjCommandBuilder.commandBuild(javaCompile, project.android), handler)
                ExceptionHandle.handleMessage(handler, project.logger)
            }
        }
    }
}