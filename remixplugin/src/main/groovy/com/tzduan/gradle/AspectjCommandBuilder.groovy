package com.tzduan.gradle


class AspectjCommandBuilder {
    static String[] commandBuild(javaCompile, android){
        String[] args = [
                "-showWeaveInfo",
                "-1.8",
                "-inpath", javaCompile.destinationDir.toString(),
                "-aspectpath", javaCompile.classpath.asPath,
                "-d", javaCompile.destinationDir.toString(),
                "-classpath", javaCompile.classpath.asPath,
                "-bootclasspath", android.bootClasspath.join(File.pathSeparator)
        ]
        return args
    }
}