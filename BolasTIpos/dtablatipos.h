#ifndef DTABLATIPOS_H
#define DTABLATIPOS_H

#include "ui_dtablatipos.h"
#include "bola.h"

#include <QVector>
#include <QDialog>
#include <QHBoxLayout>
#include <QAbstractTableModel>
#include <QModelIndex>
#include <QTimer>

class ModeloTablaTipos;

class DTablaTipos : public QDialog, public Ui::DTablaTipos{
    Q_OBJECT

public:
    DTablaTipos(QVector<Bola *> *, QWidget *parent = NULL);
    QVector<Bola*> *lasBolas;

    ModeloTablaTipos * modelo;

public slots:
    void slotActualizar();

};

class ModeloTablaTipos : public QAbstractTableModel {
public:

    QVector<Bola*> *lasBolas;
    ModeloTablaTipos(QVector<Bola *> *, QObject *parent = nullptr);

    int rowCount(const QModelIndex & parent = QModelIndex() ) const;
    int columnCount(const QModelIndex & parent = QModelIndex() ) const;

    QVariant data (const QModelIndex & index, int role = Qt::DisplayRole ) const;

    QVariant headerData(
                int section,
                Qt::Orientation orientation,
                int role = Qt::DisplayRole) const;

    void actualizar();
};

#endif
