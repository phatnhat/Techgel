package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificate;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateItems;

import java.util.List;

public abstract class AboutUsLicenseCertificateData {
    public static List<AboutUsLicenseCertificate> get(){
        AboutUsLicenseCertificate aboutUsLicenseCertificate1 = new AboutUsLicenseCertificate("Giấy phép", "License", 1);
        AboutUsLicenseCertificate aboutUsLicenseCertificate2 = new AboutUsLicenseCertificate("Chứng chỉ", "Certificate", 2);

        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems1 = new AboutUsLicenseCertificateItems(1L, "Giấy chứng nhận đăng ký doanh nghiệp công ty cổ phần", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/licenses1.png", 1, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems2 = new AboutUsLicenseCertificateItems(2L, "Giấy xác nhận đủ điều kiện kinh doanh dịch vụ phòng cháy và chữa cháy", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/licenses2.png", 2, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems3 = new AboutUsLicenseCertificateItems(3L, "Giấy phép hoạt động điện lực", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/licenses3.jpg", 3, aboutUsLicenseCertificate1);
        aboutUsLicenseCertificate1.setAboutUsLicenseCertificateItems(List.of(aboutUsLicenseCertificateItems1, aboutUsLicenseCertificateItems2, aboutUsLicenseCertificateItems3));

        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems4 = new AboutUsLicenseCertificateItems(3L, "Chứng chỉ năng lực hoạt động xây dựng", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate1.png", 1, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems5 = new AboutUsLicenseCertificateItems(3L, "Chứng nhận ISO 9001 : 2015", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate2.png", 2, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems6 = new AboutUsLicenseCertificateItems(3L, "Chứng nhận ISO 14001 : 2015", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate3.png", 3, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems7 = new AboutUsLicenseCertificateItems(3L, "Chứng nhận 45001 : 2018", "TECHGEL Business Registration License 05.04.2023", "/imgs/licenses-certificates/certificate4.png", 4, aboutUsLicenseCertificate2);
        aboutUsLicenseCertificate2.setAboutUsLicenseCertificateItems(List.of(aboutUsLicenseCertificateItems4, aboutUsLicenseCertificateItems5, aboutUsLicenseCertificateItems6, aboutUsLicenseCertificateItems7));

        return List.of(aboutUsLicenseCertificate1, aboutUsLicenseCertificate2);
    }
}
