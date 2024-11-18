#include "dinfobolas.h"
#include "bola.h"

#include <QTimer>

DInfoBolas::DInfoBolas(QVector<Bola*> * bolasPasadas, QWidget *parent): QDialog(parent){
    setupUi(this);

    this->bolas =  bolasPasadas;

    slotActualizarLista();

    QTimer * temporizador = new QTimer();

    temporizador->setInterval(1000);
    temporizador->setSingleShot(false);

    temporizador->start();

    connect (temporizador, SIGNAL(timeout()),this, SLOT(slotActualizarLista()));

}

void DInfoBolas::slotActualizarLista(){

    listaBolas->clear();

    for (int i=0;i < bolas->size(); i++) {
        QString cadena = QString("Nombre : " + bolas->at(i)->nombre + " -> Pos x: ");
        cadena += QString::number(bolas->at(i)->posX) +
            " Pos y: " + QString::number(bolas->at(i)->posY) +
            " Vel x: " + QString::number(bolas->at(i)->velX) +
            " Vel y: " + QString::number(bolas->at(i)->velY);
        listaBolas->addItem(cadena);
    }
}
