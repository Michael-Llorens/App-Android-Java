#include "dinfotabla.h"
#include <QDebug>

DInfoTabla::DInfoTabla(QVector<Bola *> *bolasPasadas, QWidget *parent): QDialog(parent),
        lasBolas(bolasPasadas){
    setupUi(this);

    modelo = new ModeloTabla(lasBolas);

    tablaBolas->setModel(modelo);

    QTimer * temporizador = new QTimer();

    temporizador->setInterval(1000);
    temporizador->setSingleShot(false);

    temporizador->start();

    connect (temporizador, SIGNAL(timeout()),this, SLOT(slotActualizar()));
}

void DInfoTabla::slotActualizar(){
    modelo->actualizar();
}


ModeloTabla::ModeloTabla(QVector<Bola *> *bolasPasadas, QObject *parent){

    lasBolas = bolasPasadas;
}

int ModeloTabla::rowCount(const QModelIndex & parent) const{    
    return lasBolas->size();
}

int ModeloTabla::columnCount(const QModelIndex & parent) const{
    return 4;
}

QVariant ModeloTabla::data (const QModelIndex & index, int role) const{

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
            cadena = QString::number(laBola->posX);
            break;

        case 1:
            cadena = QString::number(laBola->posY);
            break;

        case 2:
            cadena = QString::number(laBola->velX);
            break;

        case 3:
            cadena = QString::number(laBola->velY);
            break; 
    }

    return QVariant(cadena);
}

QVariant ModeloTabla::headerData(int section, Qt::Orientation orientation, int role) const {

    QString cadena;

    if (role != Qt::DisplayRole){
        return QVariant();
    }
    

    if (orientation == Qt::Horizontal){
        switch (section) {
            case 0:
                cadena = "Pos X";
                break;

            case 1:
                cadena = cadena = "Pos Y";
                break;

            case 2:
                cadena = cadena = "Vel X";
                break;

            case 3:
                cadena = cadena = "Vel Y";
                break; 
        }
    }

    if (orientation == Qt::Vertical){
       cadena = lasBolas->at(section)->nombre;
    }
    return QVariant(cadena);
    
}

void ModeloTabla::actualizar(){
    emit layoutChanged();
}