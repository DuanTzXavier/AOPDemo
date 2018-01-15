package com.tzduan.gradle

import org.aspectj.bridge.IMessage
import org.aspectj.bridge.MessageHandler
import org.gradle.api.logging.Logger

class ExceptionHandle {
    static void handleMessage(MessageHandler handler, Logger log){
        for (IMessage message : handler.getMessages(null, true)) {
            switch (message.getKind()) {
                case IMessage.ABORT:
                case IMessage.ERROR:
                case IMessage.FAIL:
                    log.error message.message, message.thrown
                    break
                case IMessage.WARNING:
                case IMessage.INFO:
                    log.info message.message, message.thrown
                    break
                case IMessage.DEBUG:
                    log.debug message.message, message.thrown
                    break
            }
        }
    }
}