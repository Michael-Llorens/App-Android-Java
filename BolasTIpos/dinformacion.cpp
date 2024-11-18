#include "dinformacion.h"
#include <QDebug>

DInformacion::DInformacion(int altura, int anchura, int numBolas, QWidget *parent): QDialog(parent){
    setupUi(this);

    QString dim("");
    dim = dim+QString::number(altura)+ " X " + QString::number(anchura);

    lDimensiones->setText(dim);
    lNumBolas->setText(QString::number(numBolas));

}
