#include "dcontrolbolas.h"
#include "widgetbola.h"
#include "bola.h"
#include <QDebug>

DControlBolas::DControlBolas(QVector<Bola*> * bolasPasadas, QWidget *parent): QDialog(parent){
    setupUi(this);

    tabBolas->clear();

    for (int i=0; i < bolasPasadas->size();i++){
        // tabBolas->addTab(new WidgetBola(bolasPasadas->at(i)), QString("bola") + QString::number(i));

        WidgetBola *nuevoWB = new WidgetBola(bolasPasadas->at(i));

        tabBolas->addTab(nuevoWB, bolasPasadas->at(i)->nombre);

        // connect(nuevoWB,SIGNAL(NombreCambiado()),this, SLOT(slotNombreBolaCambiado(QString)));
    }
    
}
