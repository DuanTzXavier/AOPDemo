package com.tzduan.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project


class PluginImpl implements Plugin<Project> {

    @Override
    void apply(Project project) {
        if (project.getPlugins().hasPlugin("com.android.application")){
            project.getPluginManager().apply(RemixApplication.class)
        }else if (project.getPlugins().hasPlugin("com.android.library")){
            project.getPluginManager().apply(RemixLibrary.class)
        }

        project.dependencies {
            compile 'org.aspectj:aspectjrt:1.8.12'
        }
    }
}