#include "widgetbola.h"
#include "dcontrolbolas.h"
#include "bola.h"

#include <QColorDialog>
#include <QString>
#include <QDebug>

WidgetBola::WidgetBola (Bola *bola, QWidget * ventanaPadre) : QWidget(ventanaPadre) {
    setupUi(this);

    miBola = bola;

    connect(botonParar,SIGNAL(clicked()),this, SLOT(slotParar()));
    connect(botonColor,SIGNAL(clicked()),this, SLOT(slotCambiarColor()));
}   

void WidgetBola::slotParar(){
    miBola->velX = miBola->velY = 0;
}

void WidgetBola::slotCambiarColor(){

    QColorDialog *dialogoColor;
    dialogoColor = new QColorDialog;

    QColor color = dialogoColor->getColor();
    miBola->color = color;

}
