/********************************************************************************
** Form generated from reading UI file 'dtablatipos.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DTABLATIPOS_H
#define UI_DTABLATIPOS_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QTableView>

QT_BEGIN_NAMESPACE

class Ui_DTablaTipos
{
public:
    QDialogButtonBox *buttonBox;
    QTableView *tablaBolas;
    QLabel *label;

    void setupUi(QDialog *DTablaTipos)
    {
        if (DTablaTipos->objectName().isEmpty())
            DTablaTipos->setObjectName(QString::fromUtf8("DTablaTipos"));
        DTablaTipos->resize(497, 405);
        buttonBox = new QDialogButtonBox(DTablaTipos);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(150, 370, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        tablaBolas = new QTableView(DTablaTipos);
        tablaBolas->setObjectName(QString::fromUtf8("tablaBolas"));
        tablaBolas->setGeometry(QRect(0, 30, 491, 331));
        label = new QLabel(DTablaTipos);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(0, 0, 491, 31));
        QFont font;
        font.setPointSize(14);
        font.setBold(true);
        font.setWeight(75);
        label->setFont(font);
        label->setAlignment(Qt::AlignCenter);

        retranslateUi(DTablaTipos);
        QObject::connect(buttonBox, SIGNAL(accepted()), DTablaTipos, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DTablaTipos, SLOT(reject()));

        QMetaObject::connectSlotsByName(DTablaTipos);
    } // setupUi

    void retranslateUi(QDialog *DTablaTipos)
    {
        DTablaTipos->setWindowTitle(QApplication::translate("DTablaTipos", "Dialog", nullptr));
        label->setText(QApplication::translate("DTablaTipos", "Tabla de las bolas tipos", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DTablaTipos: public Ui_DTablaTipos {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DTABLATIPOS_H
