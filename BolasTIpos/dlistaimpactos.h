#ifndef DLISTAIMPACTOS_H
#define DLISTAIMPACTOS_H
#include <QDialog>
#include <QHBoxLayout>
#include <QVector>

// Se añade el designer creado
#include "ui_dlistaimpactos.h"
#include "bola.h"


class DListaImpactos : public QDialog, public Ui::DListaImpactos{
Q_OBJECT

public:
 
    DListaImpactos(QVector<Bola *> *, QWidget * parent = NULL);

    QVector<Bola*> * bolas;

public slots:
    void slotActualizarLista();
};
#endif