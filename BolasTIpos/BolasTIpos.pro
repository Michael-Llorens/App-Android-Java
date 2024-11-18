######################################################################
# Automatically generated by qmake (3.1) Wed Mar 6 02:38:26 2024
######################################################################

TEMPLATE = app
TARGET = BolasTIpos
INCLUDEPATH += .

# The following define makes your compiler warn you if you use any
# feature of Qt which has been marked as deprecated (the exact warnings
# depend on your compiler). Please consult the documentation of the
# deprecated API in order to know how to port your code away from it.
DEFINES += QT_DEPRECATED_WARNINGS

# You can also make your code fail to compile if you use deprecated APIs.
# In order to do so, uncomment the following line.
# You can also select to disable deprecated APIs only up to a certain version of Qt.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

# Input
HEADERS += bola.h \
           dcontrolbolas.h \
           dcontrolbolastipos.h \
           dinfobolas.h \
           dinformacion.h \
           dinfotabla.h \
           dlistaimpactos.h \
           dtablatipos.h \
           mainwindow.h \
           widgetbola.h \
           widgetbolatipo.h
FORMS += dcontrolbolas.ui \
         dcontrolbolastipos.ui \
         dinfobolas.ui \
         dinformacion.ui \
         dinfotabla.ui \
         dlistaimpactos.ui \
         dtablatipos.ui \
         widgetbola.ui \
         widgetbolatipo.ui
SOURCES += bola.cpp \
           dcontrolbolas.cpp \
           dcontrolbolastipos.cpp \
           dinfobolas.cpp \
           dinformacion.cpp \
           dinfotabla.cpp \
           dlistaimpactos.cpp \
           dtablatipos.cpp \
           main.cpp \
           mainwindow.cpp \
           widgetbola.cpp \
           widgetbolatipo.cpp
QT += widgets
