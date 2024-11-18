#ifndef DINFOTABLA_H
#define DINFOTABLA_H

#include "ui_dinfotabla.h"
#include "bola.h"

#include <QVector>
#include <QDialog>
#include <QHBoxLayout>
#include <QAbstractTableModel>
#include <QModelIndex>
#include <QTimer>

class ModeloTabla;

class DInfoTabla : public QDialog, public Ui::DInfoTabla{
    Q_OBJECT

public:
    DInfoTabla(QVector<Bola *> *, QWidget *parent = NULL);
    QVector<Bola*> *lasBolas;

    ModeloTabla * modelo;

public slots:
    void slotActualizar();

};

class ModeloTabla : public QAbstractTableModel {
public:

    QVector<Bola*> *lasBolas;
    ModeloTabla(QVector<Bola *> *, QObject *parent = nullptr);

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
