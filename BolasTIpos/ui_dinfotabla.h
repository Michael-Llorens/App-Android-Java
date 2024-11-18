/********************************************************************************
** Form generated from reading UI file 'dinfotabla.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DINFOTABLA_H
#define UI_DINFOTABLA_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QTableView>

QT_BEGIN_NAMESPACE

class Ui_DInfoTabla
{
public:
    QDialogButtonBox *buttonBox;
    QTableView *tablaBolas;
    QLabel *label;

    void setupUi(QDialog *DInfoTabla)
    {
        if (DInfoTabla->objectName().isEmpty())
            DInfoTabla->setObjectName(QString::fromUtf8("DInfoTabla"));
        DInfoTabla->resize(562, 434);
        buttonBox = new QDialogButtonBox(DInfoTabla);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(210, 400, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        tablaBolas = new QTableView(DInfoTabla);
        tablaBolas->setObjectName(QString::fromUtf8("tablaBolas"));
        tablaBolas->setGeometry(QRect(10, 40, 541, 351));
        label = new QLabel(DInfoTabla);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(20, 10, 521, 20));
        QFont font;
        font.setPointSize(14);
        font.setBold(true);
        font.setWeight(75);
        label->setFont(font);
        label->setAlignment(Qt::AlignCenter);

        retranslateUi(DInfoTabla);
        QObject::connect(buttonBox, SIGNAL(accepted()), DInfoTabla, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DInfoTabla, SLOT(reject()));

        QMetaObject::connectSlotsByName(DInfoTabla);
    } // setupUi

    void retranslateUi(QDialog *DInfoTabla)
    {
        DInfoTabla->setWindowTitle(QApplication::translate("DInfoTabla", "Dialog", nullptr));
        label->setText(QApplication::translate("DInfoTabla", "Tabla de las bolas", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DInfoTabla: public Ui_DInfoTabla {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DINFOTABLA_H
