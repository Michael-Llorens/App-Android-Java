/********************************************************************************
** Form generated from reading UI file 'dlistaimpactos.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DLISTAIMPACTOS_H
#define UI_DLISTAIMPACTOS_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QListWidget>

QT_BEGIN_NAMESPACE

class Ui_DListaImpactos
{
public:
    QDialogButtonBox *buttonBox;
    QLabel *titul;
    QListWidget *listaBolas;

    void setupUi(QDialog *DListaImpactos)
    {
        if (DListaImpactos->objectName().isEmpty())
            DListaImpactos->setObjectName(QString::fromUtf8("DListaImpactos"));
        DListaImpactos->resize(621, 361);
        buttonBox = new QDialogButtonBox(DListaImpactos);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(190, 320, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        titul = new QLabel(DListaImpactos);
        titul->setObjectName(QString::fromUtf8("titul"));
        titul->setGeometry(QRect(10, 10, 521, 20));
        QFont font;
        font.setPointSize(14);
        font.setBold(true);
        font.setWeight(75);
        titul->setFont(font);
        titul->setAlignment(Qt::AlignCenter);
        listaBolas = new QListWidget(DListaImpactos);
        listaBolas->setObjectName(QString::fromUtf8("listaBolas"));
        listaBolas->setGeometry(QRect(10, 40, 601, 271));
        QFont font1;
        font1.setPointSize(12);
        listaBolas->setFont(font1);

        retranslateUi(DListaImpactos);
        QObject::connect(buttonBox, SIGNAL(accepted()), DListaImpactos, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DListaImpactos, SLOT(reject()));

        QMetaObject::connectSlotsByName(DListaImpactos);
    } // setupUi

    void retranslateUi(QDialog *DListaImpactos)
    {
        DListaImpactos->setWindowTitle(QApplication::translate("DListaImpactos", "Dialog", nullptr));
        titul->setText(QApplication::translate("DListaImpactos", "Tabla de las bolas", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DListaImpactos: public Ui_DListaImpactos {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DLISTAIMPACTOS_H
