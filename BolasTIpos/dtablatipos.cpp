#include "dtablatipos.h"
#include <QDebug>

DTablaTipos::DTablaTipos(QVector<Bola *> *bolasPasadas, QWidget *parent): QDialog(parent),
        lasBolas(bolasPasadas){
    setupUi(this);

    modelo = new ModeloTablaTipos(lasBolas);

    tablaBolas->setModel(modelo);

    QTimer * temporizador = new QTimer();

    temporizador->setInterval(1000);
    temporizador->setSingleShot(false);

    temporizador->start();

    connect (temporizador, SIGNAL(timeout()),this, SLOT(slotActualizar()));
}

void DTablaTipos::slotActualizar(){
    modelo->actualizar();
}


ModeloTablaTipos::ModeloTablaTipos(QVector<Bola *> *bolasPasadas, QObject *parent){

    lasBolas = bolasPasadas;
}

int ModeloTablaTipos::rowCount(const QModelIndex & parent) const{    
    return lasBolas->size();
}

int ModeloTablaTipos::columnCount(const QModelIndex & parent) const{
    return 4;
}

QVariant ModeloTablaTipos::data (const QModelIndex & index, int role) const{

    Bola * laBola;
    if (role != Qt::DisplayRole) {
        return QVariant();
    }

    int fila = index.row();
    int columna = index.column();

    laBola = lasBolas->at(fila);

    QString cadena;
    switch (columna) {
        case 0:
            cadena = QString::number(laBola->tipo);
            break;

        case 1:
            cadena = QString::number(laBola->vida);
            break;

        case 2:
            cadena = QString::number(laBola->impactos);
            break;

        case 3:
            cadena = QString::number(laBola->rebotes);
            break; 
    }

    return QVariant(cadena);
}

QVariant ModeloTablaTipos::headerData(int section, Qt::Orientation orientation, int role) const {

    QString cadena;

    if (role != Qt::DisplayRole){
        return QVariant();
    }
    

    if (orientation == Qt::Horizontal){
        switch (section) {
            case 0:
                cadena = "TIPO";
                break;

            case 1:
                cadena = cadena = "VIDAS";
                break;

            case 2:
                cadena = cadena = "COLISIONES";
                break;

            case 3:
                cadena = cadena = "REBOTES";
                break; 
        }
    }

    if (orientation == Qt::Vertical){
       cadena = lasBolas->at(section)->nombre;
    }
    return QVariant(cadena);
    
}

void ModeloTablaTipos::actualizar(){
    emit layoutChanged();
}