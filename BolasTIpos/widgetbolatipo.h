#ifndef WIDGETBOLATIPO_H
#define WIDGETBOLATIPO_H

#include "ui_widgetbolatipo.h"
#include "bola.h"

#include <QVector>
#include <QWidget>
#include <QHBoxLayout>

class  WidgetBolaTipo :  public QWidget, public Ui::WidgetBolaTipo {
    Q_OBJECT

public:
    Bola * miBola;
    WidgetBolaTipo(Bola * laBola, QWidget *parent = 0 );

public slots:
    void slotParar();
    void slotCambiarColor();
    void slotCambiarTipo1();
    void slotCambiarTipo2();
    void slotCambiarTipo3();
    void slotCambiarNombre();
    void slotEliminarBola();
    void slotAsignarVidas();
    void slotActualizar();
};

#endif