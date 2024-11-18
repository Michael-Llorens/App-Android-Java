#include "dlistaimpactos.h"

#include "bola.h"

#include <QMessageBox>
#include <QTimer>


DListaImpactos::DListaImpactos(QVector<Bola*> * bolasPasadas, QWidget *parent): QDialog(parent){
    setupUi(this);

    bolas = bolasPasadas;

    slotActualizarLista();

    QTimer * temporizador = new QTimer();

    temporizador->setInterval(1000);
    temporizador->setSingleShot(false);

    temporizador->start();

    connect (temporizador, SIGNAL(timeout()),this, SLOT(slotActualizarLista()));
}

void DListaImpactos::slotActualizarLista(){

    listaBolas->clear();

    for (int i=0;i < bolas->size(); i++) {
        QString cadena = QString("Nombre : " + bolas->at(i)->nombre + " -> Pos x: ");
        cadena += QString::number(bolas->at(i)->posX) +
            " Pos y: " + QString::number(bolas->at(i)->posY) +
            " Vel x: " + QString::number(bolas->at(i)->velX) +
            " Vel y: " + QString::number(bolas->at(i)->velY) + 
            " Impactos: " + QString::number(bolas->at(i)->impactos);
        listaBolas->addItem(cadena);
    }
}
