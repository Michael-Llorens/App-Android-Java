#ifndef WIDGETBOLA_H
#define WIDGETBOLA_H

#include "ui_widgetbola.h"
#include "bola.h"

#include <QVector>
#include <QWidget>
#include <QHBoxLayout>

class  WidgetBola :  public QWidget, public Ui::WidgetBola {
    Q_OBJECT

public:
    Bola * miBola;
    WidgetBola(Bola * laBola, QWidget *parent = 0 );

public slots:
    void slotParar();
    void slotCambiarColor();
};

#endif