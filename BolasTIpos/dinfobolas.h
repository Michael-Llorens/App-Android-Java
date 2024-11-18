#ifndef DINFOBOLAS_H
#define DINFOBOLAS_H
#include <QDialog>
#include <QVector>
#include <QTimer>

// Se añade el designer creado
#include "ui_dinfobolas.h"
#include "bola.h"

class DInfoBolas : public QDialog, public Ui::DInfoBolas{
Q_OBJECT

public:
    QVector<Bola *> *bolas;
    DInfoBolas(QVector<Bola *> *, QWidget * parent = NULL);

    
public slots:
    void slotActualizarLista();
};
#endif