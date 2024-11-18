#include "dcontrolbolastipos.h"

#include "widgetbolatipo.h"
#include "dlistaimpactos.h"
#include "bola.h"

#include <QMessageBox>
#include <QTimer>


DControlBolasTipos::DControlBolasTipos(QVector<Bola*> * bolasPasadas, QWidget *parent): QDialog(parent){
    setupUi(this);

    tabBolas->clear();

    bolas = bolasPasadas;

    dListaImpactos = NULL;
    dTablaTipos = NULL;

    connect(btTipo1,SIGNAL(clicked()),this, SLOT(slotTipo1()));
    connect(btTipo2,SIGNAL(clicked()),this, SLOT(slotTipo2()));
    connect(btTipo3,SIGNAL(clicked()),this, SLOT(slotTipo3()));
    
    connect(btImpactos,SIGNAL(clicked()),this, SLOT(slotListaImpactos()));
    connect(btImpactosTabla,SIGNAL(clicked()),this, SLOT(slotTablaTipos()));

    slotActualizar();

}

void DControlBolasTipos::slotTipo1(){

    seleccionTipo = 1;

    lbTipo->setText("1");

    tabBolas->clear();

    for (int i=0; i < bolas->size();i++){
        // tabBolas->addTab(new WidgetBola(bolasPasadas->at(i)), QString("bola") + QString::number(i));

        if (bolas->at(i)->tipo == 1) {
            
            WidgetBolaTipo *nuevoWB = new WidgetBolaTipo(bolas->at(i));

            tabBolas->addTab(nuevoWB, bolas->at(i)->nombre);
        }

        // connect(nuevoWB,SIGNAL(NombreCambiado()),this, SLOT(slotNombreBolaCambiado(QString)));
    }

}

void DControlBolasTipos::slotTipo2(){

    seleccionTipo = 1;

    lbTipo->setText("2");
    
    tabBolas->clear();

    for (int i=0; i < bolas->size();i++){
        // tabBolas->addTab(new WidgetBola(bolasPasadas->at(i)), QString("bola") + QString::number(i));

        if (bolas->at(i)->tipo == 2) {
            
            WidgetBolaTipo *nuevoWB = new WidgetBolaTipo(bolas->at(i));

            tabBolas->addTab(nuevoWB, bolas->at(i)->nombre);
        }

        // connect(nuevoWB,SIGNAL(NombreCambiado()),this, SLOT(slotNombreBolaCambiado(QString)));
    }
}

void DControlBolasTipos::slotTipo3(){

    seleccionTipo = 1;

    lbTipo->setText("3");

    tabBolas->clear();

    for (int i=0; i < bolas->size();i++){
        // tabBolas->addTab(new WidgetBola(bolasPasadas->at(i)), QString("bola") + QString::number(i));

        if (bolas->at(i)->tipo == 3) {
            
            WidgetBolaTipo *nuevoWB = new WidgetBolaTipo(bolas->at(i));

            tabBolas->addTab(nuevoWB, bolas->at(i)->nombre);
        }
        // connect(nuevoWB,SIGNAL(NombreCambiado()),this, SLOT(slotNombreBolaCambiado(QString)));
    }
}

void DControlBolasTipos::slotListaImpactos(){

    if (dListaImpactos == NULL) {
        dListaImpactos = new DListaImpactos(bolas);
    }
    dListaImpactos->show();
}

void DControlBolasTipos::slotActualizar(){

    lbTipo->setText("1");

    tabBolas->clear();

    for (int i=0; i < bolas->size();i++){
        // tabBolas->addTab(new WidgetBola(bolasPasadas->at(i)), QString("bola") + QString::number(i));

        if (bolas->at(i)->tipo == 1) {
            
            WidgetBolaTipo *nuevoWB = new WidgetBolaTipo(bolas->at(i));

            tabBolas->addTab(nuevoWB, bolas->at(i)->nombre);
        }

        // connect(nuevoWB,SIGNAL(NombreCambiado()),this, SLOT(slotNombreBolaCambiado(QString)));
    }
    
}

void DControlBolasTipos::slotTablaTipos(){

    if (dTablaTipos == NULL) {
        dTablaTipos = new DTablaTipos(bolas);
    }
    dTablaTipos->show();
    
}