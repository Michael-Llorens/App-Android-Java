/********************************************************************************
** Form generated from reading UI file 'dinformacion.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DINFORMACION_H
#define UI_DINFORMACION_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>

QT_BEGIN_NAMESPACE

class Ui_DInformacion
{
public:
    QDialogButtonBox *buttonBox;
    QLabel *label;
    QLabel *label_3;
    QLabel *lDimensiones;
    QLabel *lNumBolas;

    void setupUi(QDialog *DInformacion)
    {
        if (DInformacion->objectName().isEmpty())
            DInformacion->setObjectName(QString::fromUtf8("DInformacion"));
        DInformacion->resize(400, 300);
        buttonBox = new QDialogButtonBox(DInformacion);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(50, 260, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        label = new QLabel(DInformacion);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(50, 70, 141, 31));
        QFont font;
        font.setPointSize(12);
        font.setBold(true);
        font.setWeight(75);
        label->setFont(font);
        label_3 = new QLabel(DInformacion);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(50, 120, 141, 31));
        label_3->setFont(font);
        lDimensiones = new QLabel(DInformacion);
        lDimensiones->setObjectName(QString::fromUtf8("lDimensiones"));
        lDimensiones->setGeometry(QRect(200, 76, 71, 21));
        lNumBolas = new QLabel(DInformacion);
        lNumBolas->setObjectName(QString::fromUtf8("lNumBolas"));
        lNumBolas->setGeometry(QRect(200, 120, 71, 31));

        retranslateUi(DInformacion);
        QObject::connect(buttonBox, SIGNAL(accepted()), DInformacion, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DInformacion, SLOT(reject()));

        QMetaObject::connectSlotsByName(DInformacion);
    } // setupUi

    void retranslateUi(QDialog *DInformacion)
    {
        DInformacion->setWindowTitle(QApplication::translate("DInformacion", "Dialog", nullptr));
        label->setText(QApplication::translate("DInformacion", "Tama\303\261o del juego", nullptr));
        label_3->setText(QApplication::translate("DInformacion", "Numero de bolas", nullptr));
        lDimensiones->setText(QApplication::translate("DInformacion", "TextLabel", nullptr));
        lNumBolas->setText(QApplication::translate("DInformacion", "gfdgdf", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DInformacion: public Ui_DInformacion {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DINFORMACION_H
