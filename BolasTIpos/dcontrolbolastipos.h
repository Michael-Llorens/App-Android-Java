#ifndef DCONTOLBOLASTIPOS_H
#define DCONTOLBOLASTIPOS_H
#include <QDialog>
#include <QHBoxLayout>
#include <QVector>

// Se añade el designer creado
#include "ui_dcontrolbolastipos.h"

#include "bola.h"
#include "dlistaimpactos.h"
#include "dtablatipos.h"


class DControlBolasTipos : public QDialog, public Ui::DControlBolasTipos{
Q_OBJECT

public:
 
    DControlBolasTipos(QVector<Bola *> *, QWidget * parent = NULL);

    QVector<Bola*> * bolas;

    DListaImpactos *dListaImpactos;
    DTablaTipos *dTablaTipos;

    int seleccionTipo = NULL;


public slots:
    void slotTipo1();
    void slotTipo2();
    void slotTipo3();
    void slotListaImpactos();
    void slotTablaTipos();
    void slotActualizar();

};
#endif