#include "widgetbolatipo.h"
#include "dcontrolbolas.h"
#include "bola.h"

#include <QColorDialog>
#include <QDebug>
#include <QMessageBox>
#include <QPainter>
#include <QString>
#include <QTimer>

WidgetBolaTipo::WidgetBolaTipo (Bola *bola, QWidget * ventanaPadre) : QWidget(ventanaPadre) {
    setupUi(this);

    miBola = bola;

    nombreBola->setText(miBola->nombre);
    vidasBola->setText(QString::number(miBola->vida));
    tipoBola->setText(QString::number(miBola->tipo));
    colisionesBola->setText(QString::number(miBola->impactos));
    

    connect(botonParar,SIGNAL(clicked()),this, SLOT(slotParar()));
    connect(botonColor,SIGNAL(clicked()),this, SLOT(slotCambiarColor()));

    connect(btCanbiarTipo1,SIGNAL(clicked()),this, SLOT(slotCambiarTipo1()));
    connect(btCanbiarTipo2,SIGNAL(clicked()),this, SLOT(slotCambiarTipo2()));
    connect(btCanbiarTipo3,SIGNAL(clicked()),this, SLOT(slotCambiarTipo3()));

    connect(btRenombrar,SIGNAL(clicked()),this, SLOT(slotCambiarNombre()));
    connect(btEliminar,SIGNAL(clicked()),this, SLOT(slotEliminarBola()));

    connect(btvidas,SIGNAL(clicked()),this, SLOT(slotAsignarVidas()));

    // Actualizar el widget de la bola

    QTimer * temporizador = new QTimer();

    temporizador->setInterval(1000);
    temporizador->setSingleShot(false);

    temporizador->start();

    connect (temporizador, SIGNAL(timeout()),this, SLOT(slotActualizar()));

}   

void WidgetBolaTipo::slotParar(){
    miBola->velX = miBola->velY = 0;
}

void WidgetBolaTipo::slotCambiarColor(){

    QColorDialog *dialogoColor;
    dialogoColor = new QColorDialog;

    QColor color = dialogoColor->getColor();
    miBola->color = color;

}

void WidgetBolaTipo::slotCambiarTipo1(){

    if (miBola->tipo == 1) {
        QMessageBox::information(this, "ERROR", "La bola ya es de tipo 1");
    }else{
        miBola->tipo = miBola->tipo = 1;
    }

}

void WidgetBolaTipo::slotCambiarTipo2(){
    
    if (miBola->tipo == 2) {
        QMessageBox::information(this, "ERROR", "La bola ya es de tipo 2");
    }else{
        miBola->tipo = miBola->tipo = 2;
    }

}

void WidgetBolaTipo::slotCambiarTipo3(){

    if (miBola->tipo == 3) {
        QMessageBox::information(this, "ERROR", "La bola ya es de tipo 3");
    }else{
        miBola->tipo = miBola->tipo = 3;
    }
}

void WidgetBolaTipo::slotEliminarBola(){
    miBola->vida = 0;
}

void WidgetBolaTipo::slotCambiarNombre(){

    QString nuevoNombre = txtNombre->text();

    miBola->nombre = txtNombre->text();

    txtNombre->setText("");

    nombreBola->setText(nuevoNombre);

}

void WidgetBolaTipo::slotAsignarVidas(){

    int nuevaVida = spVidas->value();

    miBola->vida = nuevaVida;

    spVidas->setValue(0);

    vidasBola->setText(QString::number(nuevaVida));
}

void WidgetBolaTipo::slotActualizar(){

    nombreBola->setText(miBola->nombre);
    vidasBola->setText(QString::number(miBola->vida));
    tipoBola->setText(QString::number(miBola->tipo));
    colisionesBola->setText(QString::number(miBola->impactos));
}
