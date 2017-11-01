package ru.nyxale.zipdiff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlGenerator {

    public static void generateFiles() {
        try {
            for (int i = 0; i < 3000; i++) {
                generateXml("file" + i + ".xml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateXml(final String fileName) throws IOException {
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<FD_State_Cadastral_Valuation Version=\"01\">\n" +
            "    <General_Information>\n" +
            "        <RegionsRF>\n" +
            "            <RegionRF>54</RegionRF>\n" +
            "        </RegionsRF>\n" +
            "        <Contract_Evaluation>\n" +
            "            <Details>\n" +
            "                <Date_Doc>2011-11-08</Date_Doc>\n" +
            "                <N_Doc>155Д</N_Doc>\n" +
            "                <Date_valuation>2011-11-17</Date_valuation>\n" +
            "                <Name/>\n" +
            "                <Duration>\n" +
            "                    <Started>0001-01-01</Started>\n" +
            "                    <Stopped>0001-01-01</Stopped>\n" +
            "                </Duration>\n" +
            "            </Details>\n" +
            "            <Customer>\n" +
            "                <Name_OPF/>\n" +
            "                <Code_OPF/>\n" +
            "                <Name>Федеральный орган исполнительной власти \"Федеральная служба государственной\n" +
            "                    регистрации, кадастра и картографии\"</Name>\n" +
            "                <Code_OGRN>1047796940465</Code_OGRN>\n" +
            "                <Date_OGRN>2009-03-23</Date_OGRN>\n" +
            "                <Address>109028, Россия, г. Москва, ул. Воронцово поле, д.4а</Address>\n" +
            "            </Customer>\n" +
            "            <Administrant>\n" +
            "                <Name_OPF/>\n" +
            "                <Code_OPF/>\n" +
            "                <Name>ООО ГКР</Name>\n" +
            "                <Code_OGRN>1025203752375</Code_OGRN>\n" +
            "                <Date_OGRN>1900-01-01</Date_OGRN>\n" +
            "                <Address>603140, г. Нижний Новгород, пер. Мотальный, д.8, офис А-301</Address>\n" +
            "                <Appraiser>\n" +
            "                    <Address>603140, г. Нижний Новгород, пер. Мотальный, д.8, офис А-301</Address>\n" +
            "                    <FIO>\n" +
            "                        <Surname/>\n" +
            "                        <First/>\n" +
            "                        <Patronymic/>\n" +
            "                    </FIO>\n" +
            "                </Appraiser>\n" +
            "            </Administrant>\n" +
            "        </Contract_Evaluation>\n" +
            "        <Report_Details Date=\"2012-06-08\" Number=\"01-ГКООН-54-2012\">\n" +
            "            <Name_Org/>\n" +
            "        </Report_Details>\n" +
            "    </General_Information>\n" +
            "    <Package>\n" +
            "        <Groups_Real_Estates>";

        String footer = "</Groups_Real_Estates>\n" +
            "        <Evaluative_Factors>\n" +
            "            <Evaluative_Factor Id_Factor=\"2\" Type=\"2\">\n" +
            "                <Name_Factor>Площадь</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"386\" Type=\"2\">\n" +
            "                <Name_Factor>Площадь земельного участка</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"406\" Type=\"2\">\n" +
            "                <Name_Factor>Численность населения в населенных пунктах</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"477\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние до административного центра</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"482\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние до ж/д дороги</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"483\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние до жилых кварталов</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"488\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние до общественно-делового центра</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"489\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние до основных дорог города</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"491\" Type=\"1\">\n" +
            "                <Name_Factor>_Районы города</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>20661</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Дзержинский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>20662</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Кировский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>20663</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Октябрьский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>20759</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Академическая зона</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>21543</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Железнодорожный район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>21544</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Заельцовский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>21545</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Ленинский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>21546</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Центральный район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>32165</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Калининский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>32166</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Первомайский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>32167</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Советский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"492\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние до станций метрополитена</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"493\" Type=\"1\">\n" +
            "                <Name_Factor>_Центральное теплоснабжение</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24497</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Нет</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33365</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Есть</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"496\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние от населенного пункта до столицы субъекта</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"499\" Type=\"1\">\n" +
            "                <Name_Factor>_СНП_Наличие в населенном пункте или вблизи (до 1 км) остановок\n" +
            "                    общественного транспорта</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24858</Qualitative_Id>\n" +
            "                        <Qualitative_Value>да</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33491</Qualitative_Id>\n" +
            "                        <Qualitative_Value>нет</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"507\" Type=\"1\">\n" +
            "                <Name_Factor>_СНП_Наличие в населенном пункте или вблизи (до 1 км) водного объекта</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24505</Qualitative_Id>\n" +
            "                        <Qualitative_Value>нет</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25026</Qualitative_Id>\n" +
            "                        <Qualitative_Value> нет</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25027</Qualitative_Id>\n" +
            "                        <Qualitative_Value>да</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"514\" Type=\"1\">\n" +
            "                <Name_Factor>_СНП_Наличие в населенном пункте общеобразовательной школы</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24506</Qualitative_Id>\n" +
            "                        <Qualitative_Value>нет</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24859</Qualitative_Id>\n" +
            "                        <Qualitative_Value>да</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"524\" Type=\"1\">\n" +
            "                <Name_Factor>Этаж расположения</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24507</Qualitative_Id>\n" +
            "                        <Qualitative_Value>1</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33492</Qualitative_Id>\n" +
            "                        <Qualitative_Value>2</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"529\" Type=\"1\">\n" +
            "                <Name_Factor>Площадь 1 группа</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24508</Qualitative_Id>\n" +
            "                        <Qualitative_Value>4</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24860</Qualitative_Id>\n" +
            "                        <Qualitative_Value>1</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33493</Qualitative_Id>\n" +
            "                        <Qualitative_Value>2</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33494</Qualitative_Id>\n" +
            "                        <Qualitative_Value>3</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"532\" Type=\"1\">\n" +
            "                <Name_Factor>Этажность 1 группа</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24509</Qualitative_Id>\n" +
            "                        <Qualitative_Value>3</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24510</Qualitative_Id>\n" +
            "                        <Qualitative_Value>5</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24861</Qualitative_Id>\n" +
            "                        <Qualitative_Value>9</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33495</Qualitative_Id>\n" +
            "                        <Qualitative_Value>12</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"545\" Type=\"1\">\n" +
            "                <Name_Factor>Ветхий и аварийный фонд</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25028</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Аварийное</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33496</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Ветхий фонд</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"550\" Type=\"2\">\n" +
            "                <Name_Factor>Год постройки-кол</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"551\" Type=\"1\">\n" +
            "                <Name_Factor>Материал стен-фактор</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24925</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Дерево</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24926</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Иное</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33537</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Кирпич</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33538</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Кирпич, монолит</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"557\" Type=\"1\">\n" +
            "                <Name_Factor>Наличие вблизи (до 1 км) водного объекта</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24604</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Нет</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25062</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Да</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"559\" Type=\"1\">\n" +
            "                <Name_Factor>Тип гаража</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24605</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Парковочное место</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24927</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Капитальный гараж</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33539</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Металлический (деревянный) гараж</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"560\" Type=\"1\">\n" +
            "                <Name_Factor>Площадь 5 группа</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24606</Qualitative_Id>\n" +
            "                        <Qualitative_Value>1</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25063</Qualitative_Id>\n" +
            "                        <Qualitative_Value>2</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"561\" Type=\"1\">\n" +
            "                <Name_Factor>Площадь 7 группа</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24607</Qualitative_Id>\n" +
            "                        <Qualitative_Value>4</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24928</Qualitative_Id>\n" +
            "                        <Qualitative_Value>1</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25064</Qualitative_Id>\n" +
            "                        <Qualitative_Value>2</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25065</Qualitative_Id>\n" +
            "                        <Qualitative_Value>3</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25066</Qualitative_Id>\n" +
            "                        <Qualitative_Value>5</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"563\" Type=\"1\">\n" +
            "                <Name_Factor>_Район города_Новый</Name_Factor>\n" +
            "                <QualitativeValues>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24608</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Дзержинский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24609</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Железнодорожный район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24610</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Ленинский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24611</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Октябрьский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24612</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Первомайский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24929</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Калининский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>24930</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Кировский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>25067</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Советский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33540</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Академическая зона</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33541</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Заельцовский район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                    <QualitativeValue>\n" +
            "                        <Qualitative_Id>33542</Qualitative_Id>\n" +
            "                        <Qualitative_Value>Центральный район</Qualitative_Value>\n" +
            "                    </QualitativeValue>\n" +
            "                </QualitativeValues>\n" +
            "            </Evaluative_Factor>\n" +
            "            <Evaluative_Factor Id_Factor=\"566\" Type=\"2\">\n" +
            "                <Name_Factor>_Расстояние до локального общественного центра Академгородка</Name_Factor>\n" +
            "                <Quantitative_Dimension>empty</Quantitative_Dimension>\n" +
            "            </Evaluative_Factor>\n" +
            "        </Evaluative_Factors>\n" +
            "        <Appraise>\n" +
            "            <Valuation>\n" +
            "                <Group_Real_Estate_Valuation ID_Group=\"1531\">\n" +
            "                    <Rational> </Rational>\n" +
            "                    <Real_Estates>\n" +
            "                        <Real_Estate>\n" +
            "                            <CadastralNumber>54:27:000000:283</CadastralNumber>\n" +
            "                            <Type>Здание</Type>\n" +
            "                        </Real_Estate>\n" +
            "                        <Real_Estate>\n" +
            "                            <CadastralNumber>54:13:010304:84</CadastralNumber>\n" +
            "                            <Type>Здание</Type>\n" +
            "                        </Real_Estate>\n" +
            "                        <Real_Estate>\n" +
            "                            <CadastralNumber>54:24:021101:150</CadastralNumber>\n" +
            "                            <Type>Здание</Type>\n" +
            "                        </Real_Estate>\n" +
            "                        <Real_Estate>\n" +
            "                            <CadastralNumber>54:24:021101:146</CadastralNumber>\n" +
            "                            <Type>Здание</Type>\n" +
            "                        </Real_Estate>\n" +
            "                    </Real_Estates>\n" +
            "                </Group_Real_Estate_Valuation>\n" +
            "            </Valuation>\n" +
            "            <Market_Values>\n" +
            "                <Date>Date</Date>\n" +
            "                <Numbers>Numbers</Numbers>\n" +
            "                <Appraiser>\n" +
            "                    <Address>603140, г. Н</Address>\n" +
            "                    <FIO>\n" +
            "                        <Surname/>\n" +
            "                        <Name/>\n" +
            "                        <Patronymic/>\n" +
            "                    </FIO>\n" +
            "                </Appraiser>\n" +
            "                <Applied_Documents>\n" +
            "                    <AppliedFile File=\"File\" Name=\"Name\"/>\n" +
            "                </Applied_Documents>\n" +
            "            </Market_Values>\n" +
            "        </Appraise>\n" +
            "    </Package>\n" +
            "</FD_State_Cadastral_Valuation>\n";
        StringBuilder builder = new StringBuilder();
        builder.append(header);
        for (int i = 0; i < 35000; i++) {
            builder.append("<Group_Real_Estate>\n" +
                "                <ID_Group>" + i + "</ID_Group>\n" +
                "                <Name_Group>3. Мелкие ГНП_ЗП</Name_Group>\n" +
                "            </Group_Real_Estate>");
        }
        builder.append(footer);
        String xml = builder.toString();

        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(xml);
        writer.close();
    }
}
