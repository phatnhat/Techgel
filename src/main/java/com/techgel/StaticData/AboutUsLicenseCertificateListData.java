package com.techgel.StaticData;

import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateItems;
import com.techgel.common.entity.adminSettings.AboutUsLicenseCertificateList;

import java.util.List;

public abstract class AboutUsLicenseCertificateListData {
    public static List<AboutUsLicenseCertificateList> get(){
        AboutUsLicenseCertificateList aboutUsLicenseCertificate1 = new AboutUsLicenseCertificateList("Giấy phép", "Licenses", 1);
        AboutUsLicenseCertificateList aboutUsLicenseCertificate2 = new AboutUsLicenseCertificateList("Chứng chỉ", "Certificates", 2);

        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems1 = new AboutUsLicenseCertificateItems(1L, "Chứng nhận ISO 45001:2018", "ISO 45001:2018 Certification", "/imgs/licenses-certificates/iso45001_2018.jpg", "/imgs/licenses-certificates/iso45001_2018_en.jpg", 1, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems2 = new AboutUsLicenseCertificateItems(2L, "Chứng nhận ISO 14001:2015", "ISO 14001:2015 Certification", "/imgs/licenses-certificates/iso14001_2015.jpg", "/imgs/licenses-certificates/iso14001_2015_en.jpg", 2, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems3 = new AboutUsLicenseCertificateItems(3L, "Chứng chỉ năng lực hoạt động xây dựng", "Certificate of Construction Activity Competency", "/imgs/licenses-certificates/construction_activity_competency.jpg", "/imgs/licenses-certificates/construction_activity_competency.jpg", 3, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems4 = new AboutUsLicenseCertificateItems(4L, "Chứng chỉ năng lực hoạt động xây dựng", "Certificate of Construction Activity Competency", "/imgs/licenses-certificates/construction_activity_competency2.jpg", "/imgs/licenses-certificates/construction_activity_competency2.jpg", 4, aboutUsLicenseCertificate2);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems5 = new AboutUsLicenseCertificateItems(5L, "Chứng chỉ năng lực hoạt động xây dựng", "Certificate of Construction Activity Competency", "/imgs/licenses-certificates/construction_activity_competency3.jpg", "/imgs/licenses-certificates/construction_activity_competency3.jpg", 5, aboutUsLicenseCertificate2);


        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems6 = new AboutUsLicenseCertificateItems(6L, "Giấy xác nhận đủ điều kiện kinh doanh dịch vụ phòng cháy và chữa cháy", "Certificate of Eligibility for Fire Prevention and Fighting Service Business", "/imgs/licenses-certificates/eligibility_for_fire_prevention.jpg", "/imgs/licenses-certificates/eligibility_for_fire_prevention.jpg", 1, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems7 = new AboutUsLicenseCertificateItems(7L, "Giấy phép hoạt động điện lực", "Electricity Operation License", "/imgs/licenses-certificates/electricity_operation_license.jpg", "/imgs/licenses-certificates/electricity_operation_license.jpg", 2, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems8 = new AboutUsLicenseCertificateItems(8L, "Giấy phép hoạt động điện lực", "Electricity Operation License", "/imgs/licenses-certificates/electricity_operation_license2.jpg", "/imgs/licenses-certificates/electricity_operation_license2.jpg", 3, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems9 = new AboutUsLicenseCertificateItems(9L, "Danh mục ngành nghề được phép kinh doanh dịch vụ phòng cháy và chữa cháy", "List of Business Lines Permitted to Provide Fire Prevention and Fighting Services", "/imgs/licenses-certificates/list_provide_fire_prevention.jpg", "/imgs/licenses-certificates/list_provide_fire_prevention.jpg", 4, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems11 = new AboutUsLicenseCertificateItems(11L, "Giấy chứng nhận đăng ký nhãn hiệu hàng hóa", "Certificate of Trademark Registration", "/imgs/licenses-certificates/certificate_of_trademark.jpg", "/imgs/licenses-certificates/certificate_of_trademark.jpg", 6, aboutUsLicenseCertificate1);
        AboutUsLicenseCertificateItems aboutUsLicenseCertificateItems12 = new AboutUsLicenseCertificateItems(12L, "Giấy chứng nhận đăng ký doanh nghiệp công ty cổ phần", "Certificate of Business Registration for a Joint Stock Company", "/imgs/licenses-certificates/licenses1.png", "/imgs/licenses-certificates/licenses1.png", 7, aboutUsLicenseCertificate1);

        aboutUsLicenseCertificate1.setAboutUsLicenseCertificateItems(List.of(aboutUsLicenseCertificateItems6, aboutUsLicenseCertificateItems7, aboutUsLicenseCertificateItems8, aboutUsLicenseCertificateItems9, aboutUsLicenseCertificateItems11, aboutUsLicenseCertificateItems12));
        aboutUsLicenseCertificate2.setAboutUsLicenseCertificateItems(List.of(aboutUsLicenseCertificateItems1, aboutUsLicenseCertificateItems2, aboutUsLicenseCertificateItems3, aboutUsLicenseCertificateItems4, aboutUsLicenseCertificateItems5));

        return List.of(aboutUsLicenseCertificate1, aboutUsLicenseCertificate2);
    }
}
