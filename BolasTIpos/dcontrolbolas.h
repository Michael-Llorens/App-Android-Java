#ifndef DCONTROLBOLAS_H
#define DCONTROLBOLAS_H

#include "ui_dcontrolbolas.h"
#include "bola.h"

#include <QVector>
#include <QDialog>
#include <QHBoxLayout>

class  DControlBolas :  public QDialog, public Ui::DControlBolas {
    Q_OBJECT

public:
    DControlBolas(QVector<Bola *> *, QWidget* parent = 0);

public slots:

};

#endif