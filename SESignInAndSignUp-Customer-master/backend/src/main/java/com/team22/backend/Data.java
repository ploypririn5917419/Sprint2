package com.team22.backend;

import com.team22.backend.Repository.*;
import com.team22.backend.Entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class Data {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Data.class, args);
    }

    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    ApplicationRunner init(PositionRepository positionRepository, StaffRepository staffRepository,
            SellingRepository sellingRepository, EducationRepository educationRepository,
            DetailRepository detailRepository, ProductRepository productRepository, StatusRepository statusRepository,
            BookingRepository bookingRepository, CustomerRepository customerRepository, TypeRepository typeRepository,
            StyleRepository styleRepository, LeaseRepository leaseRepository, PayMentRepository payMentRepository,
            ExperienceRepository experienceRepository, ProvinceRepository provinceRepository,
            CareerRepository careerRepository,BookingCancleRepository bookingCancleRepository,
            TypeReasonRepository typeReasonRepository
            ) {
        return args -> {

            Stream.of("Renting", "Selling", "Stocking").forEach(status -> {
                Status state = new Status(status);
                statusRepository.save(state);
            });
            Status sta1 = statusRepository.findByStateId(1L);
            Status sta2 = statusRepository.findByStateId(2L);
            Status sta3 = statusRepository.findByStateId(3L);
            Stream.of("Cloth", "Shoes", "Cosmetic", "Hair", "Accessories", "OtherType").forEach(tName -> {
                Type typeprodName = new Type(tName);
                typeRepository.save(typeprodName);
            });
            Stream.of("Bust", "Waist", "Hip", "Length", "Size", "OtherDetail").forEach(dName -> {
                Detail dprodName = new Detail(dName);
                detailRepository.save(dprodName);
            });

            Stream.of("M.3", "M.6", "Polytechnical College", "Technical College", "Bachelor Degrees", "Master Degrees")
                    .forEach(EduName -> {
                        Education educationdb = new Education();
                        educationdb.setEducationName(EduName);
                        educationRepository.save(educationdb);

                        if (EduName == "M.3") {
                            educationdb.setEducationIds("E" + educationdb.getEducationId());
                            educationdb.setEducationName(EduName);
                            educationRepository.save(educationdb);
                        } else if (EduName == "M.6") {
                            educationdb.setEducationIds("E" + educationdb.getEducationId());
                            educationdb.setEducationName(EduName);
                            educationRepository.save(educationdb);
                        } else if (EduName == "Polytechnical College") {
                            educationdb.setEducationIds("E" + educationdb.getEducationId());
                            educationdb.setEducationName(EduName);
                            educationRepository.save(educationdb);
                        } else if (EduName == "Technical College") {
                            educationdb.setEducationIds("E" + educationdb.getEducationId());
                            educationdb.setEducationName(EduName);
                            educationRepository.save(educationdb);
                        } else if (EduName == "Bachelor Degrees") {
                            educationdb.setEducationIds("E" + educationdb.getEducationId());
                            educationdb.setEducationName(EduName);
                            educationRepository.save(educationdb);
                        } else if (EduName == "Master Degrees") {
                            educationdb.setEducationIds("E" + educationdb.getEducationId());
                            educationdb.setEducationName(EduName);
                            educationRepository.save(educationdb);
                        }
                    });

            Education ed1 = educationRepository.findByEducationId(1L);
            Education ed2 = educationRepository.findByEducationId(2L);
            Education ed3 = educationRepository.findByEducationId(3L);
            Education ed4 = educationRepository.findByEducationId(4L);
            Education ed5 = educationRepository.findByEducationId(5L);
            Education ed6 = educationRepository.findByEducationId(6L);

            Stream.of("0 Year", "1-3 Year", "4-6 Year", "7-9 Year", "10 to Up").forEach(ExName -> {
                Experience experiencedb = new Experience();
                experiencedb.setExperienceName(ExName);
                experienceRepository.save(experiencedb);

                if (ExName == "0 Year") {
                    experiencedb.setExperienceIds("Ex" + experiencedb.getExperienceId());
                    experiencedb.setExperienceName(ExName);
                    experienceRepository.save(experiencedb);
                } else if (ExName == "1-3 Year") {
                    experiencedb.setExperienceIds("Ex" + experiencedb.getExperienceId());
                    experiencedb.setExperienceName(ExName);
                    experienceRepository.save(experiencedb);
                }
                if (ExName == "4-6 Year") {
                    experiencedb.setExperienceIds("Ex" + experiencedb.getExperienceId());
                    experiencedb.setExperienceName(ExName);
                    experienceRepository.save(experiencedb);
                } else if (ExName == "7-9 Year") {
                    experiencedb.setExperienceIds("Ex" + experiencedb.getExperienceId());
                    experiencedb.setExperienceName(ExName);
                    experienceRepository.save(experiencedb);
                } else if (ExName == "10 to Up") {
                    experiencedb.setExperienceIds("Ex" + experiencedb.getExperienceId());
                    experiencedb.setExperienceName(ExName);
                    experienceRepository.save(experiencedb);
                }
            });
            Experience ex1 = experienceRepository.findByExperienceId(1L);
            Experience ex2 = experienceRepository.findByExperienceId(2L);
            Experience ex3 = experienceRepository.findByExperienceId(3L);
            Experience ex4 = experienceRepository.findByExperienceId(4L);
            Experience ex5 = experienceRepository.findByExperienceId(5L);

            String dateB1 = "20:04:1997";
            String dateB2 = "21:05:1996";
            DateTimeFormatter lformatterb = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate dateB1c = LocalDate.parse(dateB1, lformatterb);
            LocalDate dateB2c = LocalDate.parse(dateB2, lformatterb);

            Stream.of("กระบี่", "กรุงเทพมหานคร", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี",
                    "ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท", "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด",
                    "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช", "นครสวรรค์", "นนทบุรี",
                    "นราธิวาส", "น่าน", "บุรีรัมย์", "บึงกาฬ", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี",
                    "พะเยา", "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่", "ภูเก็ต",
                    "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน", "ยโสธร", "ยะลา", "ร้อยเอ็ด", "ระนอง", "ระยอง", "ราชบุรี",
                    "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล", "สมุทรปราการ",
                    "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย", "สุพรรณบุรี",
                    "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย", "หนองบัวลำภู", "อยุธยา", "อ่างทอง", "อำนาจเจริญ", "อุดรธานี",
                    "อุตรดิตถ์", "อุทัยธานี", "อุบลราชธานี").forEach(provinceName -> {
                        Province provinces = new Province();
                        provinces.setProvinceName(provinceName);
                        provinceRepository.save(provinces);
                    });
            Province province1 = provinceRepository.findByProvinceId(1L);
            Province province2 = provinceRepository.findByProvinceId(2L);
            Province province3 = provinceRepository.findByProvinceId(3L);
            Province province4 = provinceRepository.findByProvinceId(4L);
            Province province5 = provinceRepository.findByProvinceId(5L);
            Province province6 = provinceRepository.findByProvinceId(6L);

            Stream.of("ค้าขาย", "วิศวกร", "หมอ", "พยาบาล", "นักดนดรี", "ข้าราชการ", "นักการเมือง", "ครู", "ช่าง",
                    "นักเขียนโปรแกรม", "นักกีฬา", "นักกีฬา", "อื่นๆ").forEach(careerName -> {
                        Career career = new Career();
                        career.setCareerName(careerName);
                        careerRepository.save(career);
                    });
            Career career1 = careerRepository.findByCareerId(1L);
            Career career2 = careerRepository.findByCareerId(2L);
            Career career3 = careerRepository.findByCareerId(3L);
            Career career4 = careerRepository.findByCareerId(4L);
            Career career5 = careerRepository.findByCareerId(5L);
            Career career6 = careerRepository.findByCareerId(6L);

            Customer customerdb1 = new Customer();
            customerdb1.setCusId(1L);
            customerdb1.setCustomerIDs("C1");
            customerdb1.setCustomerName("Sunvo");
            customerdb1.setCustomerPassword("123456");
            customerdb1.setCustomerAddress("Korat");
            customerdb1.setCustomerPhone("0987654321");
            customerdb1.setCustomerGender("Man");
            customerdb1.setCustomerBirthday(dateB1c);
            customerdb1.setCareer(career1);
            customerdb1.setProvince(province1);
            customerRepository.save(customerdb1);

            Customer customerdb2 = new Customer();
            customerdb2.setCusId(2L);
            customerdb2.setCustomerIDs("C2");
            customerdb2.setCustomerName("Ploy");
            customerdb2.setCustomerPassword("123456");
            customerdb2.setCustomerAddress("Suranaree");
            customerdb2.setCustomerPhone("0987654321");
            customerdb2.setCustomerGender("Man");
            customerdb2.setCustomerBirthday(dateB2c);
            customerdb2.setCareer(career2);
            customerdb2.setProvince(province2);
            customerRepository.save(customerdb2);

            Customer customerdb3 = new Customer();
            customerdb3.setCusId(3L);
            customerdb3.setCustomerIDs("C3");
            customerdb3.setCustomerName("Ao");
            customerdb3.setCustomerPassword("123456");
            customerdb3.setCustomerAddress("Sungneon");
            customerdb3.setCustomerPhone("0987654321");
            customerdb3.setCustomerGender("Man");
            customerdb3.setCustomerBirthday(dateB1c);
            customerdb3.setCareer(career3);
            customerdb3.setProvince(province3);
            customerRepository.save(customerdb3);

            Customer customerdb4 = new Customer();
            customerdb4.setCusId(4L);
            customerdb4.setCustomerIDs("C4");
            customerdb4.setCustomerName("Wahn");
            customerdb4.setCustomerPassword("123456");
            customerdb4.setCustomerAddress("Krathok");
            customerdb4.setCustomerPhone("0987654321");
            customerdb4.setCustomerGender("Man");
            customerdb4.setCustomerBirthday(dateB2c);
            customerdb4.setCareer(career4);
            customerdb4.setProvince(province4);
            customerRepository.save(customerdb4);

            Customer customerdb5 = new Customer();
            customerdb5.setCusId(5L);
            customerdb5.setCustomerIDs("C5");
            customerdb5.setCustomerName("Opal");
            customerdb5.setCustomerPassword("123456");
            customerdb5.setCustomerAddress("Khonkan");
            customerdb5.setCustomerPhone("0987654321");
            customerdb5.setCustomerGender("Man");
            customerdb5.setCustomerBirthday(dateB1c);
            customerdb5.setCareer(career5);
            customerdb5.setProvince(province5);
            customerRepository.save(customerdb5);

            Customer customerdb6 = new Customer();
            customerdb6.setCusId(6L);
            customerdb6.setCustomerIDs("C6");
            customerdb6.setCustomerName("Meen");
            customerdb6.setCustomerPassword("123456");
            customerdb6.setCustomerAddress("Korat");
            customerdb6.setCustomerPhone("0987654321");
            customerdb6.setCustomerGender("Man");
            customerdb6.setCustomerBirthday(dateB2c);
            customerdb6.setCareer(career6);
            customerdb6.setProvince(province6);
            customerRepository.save(customerdb6);

            Customer c1 = customerRepository.findByCusId(1L);
            Customer c2 = customerRepository.findByCusId(2L);
            Customer c3 = customerRepository.findByCusId(3L);
            Customer c4 = customerRepository.findByCusId(4L);
            Customer c5 = customerRepository.findByCusId(5L);
            Customer c6 = customerRepository.findByCusId(6L);

            Type type1 = typeRepository.findByTypeIds(1L);
            Stream.of("Dress").forEach(proName -> {
                Product productName = new Product();
                productName.setProductName(proName);
                productRepository.save(productName);

                if (proName == "Dress") {
                    Product prodid = productRepository.findByProdId(1L);
                    productName.setProductIds("P" + prodid.getProdId());
                    productName.setProductPrice(1000);
                    productName.setProductQuantity(18);
                    productName.setStatus(sta1);
                    productName.setType(type1);
                    productRepository.save(productName);
                }

            });
            Product pt1 = productRepository.findByProdId(1L);
       
                        
                        
                            Style styledb1 = new Style();
                            styledb1.setStyleID(1L);
                            styledb1.setStyleIDs("Sy1");
                            styledb1.setStyleName("korea style");
                            styledb1.setStylePrice(3000);
                            styleRepository.save(styledb1);

                            Style styledb2 = new Style();
                            styledb2.setStyleID(2L);
                            styledb2.setStyleIDs("Sy2");
                            styledb2.setStyleName("thai style");
                            styledb2.setStylePrice(2000);
                            styleRepository.save(styledb2);

                            Style styledb3 = new Style();
                            styledb3.setStyleID(3L);
                            styledb3.setStyleIDs("Sy3");
                            styledb3.setStyleName("laos style");
                            styledb3.setStylePrice(1700);
                            styleRepository.save(styledb3);

                            Style styledb4 = new Style();
                            styledb4.setStyleID(4L);
                            styledb4.setStyleIDs("Sy4");
                            styledb4.setStyleName("wedding");
                            styledb4.setStylePrice(5000);
                            styleRepository.save(styledb4);

                            Style styledb5 = new Style();
                            styledb5.setStyleID(5L);
                            styledb5.setStyleIDs("Sy5");
                            styledb5.setStyleName("thai wedding");
                            styledb5.setStylePrice(4500);
                            styleRepository.save(styledb5);

                            Style styledb6 = new Style();
                            styledb6.setStyleID(6L);
                            styledb6.setStyleIDs("Sy6");
                            styledb6.setStyleName("chinese style");
                            styledb6.setStylePrice(2500);
                            styleRepository.save(styledb6);
                       
            Style sy1 = styleRepository.findBystyleID(1L);
            Style sy2 = styleRepository.findBystyleID(2L);
            Style sy3 = styleRepository.findBystyleID(3L);
            Style sy4 = styleRepository.findBystyleID(4L);
            Style sy5 = styleRepository.findBystyleID(5L);
            Style sy6 = styleRepository.findBystyleID(6L);

            Stream.of("Stylist", "Service", "HairStylist", "MakeupArtist", "Renter", "Seller", "Accountant")
                    .forEach(posName -> {
                        Position positiondb = new Position();
                        positiondb.setPositionName(posName);
                        positionRepository.save(positiondb);

                        if (posName == "Stylist") {
                            positiondb.setPositionIds("P" + positiondb.getPositionId());
                            positiondb.setPositionName(posName);
                            positionRepository.save(positiondb);
                        }

                    else if (posName == "Service") {
                            positiondb.setPositionIds("P" + positiondb.getPositionId());
                            positiondb.setPositionName(posName);
                            positionRepository.save(positiondb);
                        }

                    else if (posName == "HairStylist") {
                            positiondb.setPositionIds("P" + positiondb.getPositionId());
                            positiondb.setPositionName(posName);
                            positionRepository.save(positiondb);
                        }

                    else if (posName == "MakeupArtist") {
                            positiondb.setPositionIds("P" + positiondb.getPositionId());
                            positiondb.setPositionName(posName);
                            positionRepository.save(positiondb);
                        }

                    else if (posName == "Renter") {
                            positiondb.setPositionIds("P" + positiondb.getPositionId());
                            positiondb.setPositionName(posName);
                            positionRepository.save(positiondb);
                        }

                    else if (posName == "Seller") {
                            positiondb.setPositionIds("P" + positiondb.getPositionId());
                            positiondb.setPositionName(posName);
                            positionRepository.save(positiondb);
                        }

                    else if (posName == "Accountant") {
                            positiondb.setPositionIds("P" + positiondb.getPositionId());
                            positiondb.setPositionName(posName);
                            positionRepository.save(positiondb);
                        }
                    });

            Position po1 = positionRepository.findByPositionId(1L);
            Position po2 = positionRepository.findByPositionId(2L);
            Position po3 = positionRepository.findByPositionId(3L);
            Position po4 = positionRepository.findByPositionId(4L);
            Position po5 = positionRepository.findByPositionId(5L);
            Position po6 = positionRepository.findByPositionId(6L);
            Position po7 = positionRepository.findByPositionId(7L);

            Stream.of("Owner", "Ploy", "Sunvo", "Au").forEach(staffName -> {
                Staff staffdb = new Staff();
                staffdb.setStaffName(staffName);
                staffRepository.save(staffdb);

                if (staffName == "Owner") {
                    staffdb.setStaffIds("St" + staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setStaffPassword("123456");
                    staffdb.setEducation(ed1);
                    staffdb.setExperience(ex1);
                    staffdb.setStaffGender("Man");
                    staffdb.setStaffJobtype("Full Time");
                    staffdb.setStaffPhone("086-141-9833");
                    staffdb.setStaffSalary(50000);
                    staffdb.setPosition(po6);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                } else if (staffName == "Ploy") {
                    staffdb.setStaffIds("St" + staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setStaffPassword("123456");
                    staffdb.setStaffGender("Woman");
                    staffdb.setStaffJobtype("Part Time");
                    staffdb.setEducation(ed2);
                    staffdb.setExperience(ex2);
                    staffdb.setStaffPhone("081-108-6599");
                    staffdb.setStaffSalary(29000);
                    staffdb.setPosition(po5);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                } else if (staffName == "Sunvo") {
                    staffdb.setStaffIds("St" + staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setStaffPassword("123456");
                    staffdb.setStaffGender("Man");
                    staffdb.setStaffJobtype("Part Time");
                    staffdb.setEducation(ed3);
                    staffdb.setExperience(ex3);
                    staffdb.setStaffPhone("081-105-6559");
                    staffdb.setStaffSalary(20000);
                    staffdb.setPosition(po4);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                } else if (staffName == "Au") {
                    staffdb.setStaffIds("St" + staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setStaffPassword("123456");
                    staffdb.setStaffGender("Man");
                    staffdb.setStaffJobtype("Part Time");
                    staffdb.setEducation(ed4);
                    staffdb.setExperience(ex4);
                    staffdb.setStaffPhone("081-103-6559");
                    staffdb.setStaffSalary(2500);
                    staffdb.setPosition(po3);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                }
            });
            Staff st1 = staffRepository.findByStaffId(1L);
            Staff st2 = staffRepository.findByStaffId(2L);

            Booking bookingdb = new Booking();
            String bDate1 = "20:04:1998";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate bdate = LocalDate.parse(bDate1, formatter);
            bookingdb.setBookingId(1L);
            bookingdb.setBookingDate(bdate);
            bookingdb.setStatus("not paid");
            bookingdb.setStatusBooking("Booking");
            bookingdb.setCategory("งานวันเกิด");
            bookingdb.setStaff(st1);
            bookingdb.setCustomer(c3);
            bookingdb.setStyle(sy1);
            bookingRepository.save(bookingdb);

            Lease leasedb = new Lease();
            String lDate1 = "20:04:1998";
            String lDate2 = "21:05:1998";
            DateTimeFormatter lformatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate ldate = LocalDate.parse(lDate1, lformatter);
            LocalDate ldate1 = LocalDate.parse(lDate2, lformatter);
            leasedb.setCustomer(c3);
            leasedb.setDateStart(ldate);
            leasedb.setDateEnd(ldate1);
            leasedb.setStatus("paid");
            leasedb.setStaff(st1);
            leasedb.setProduct(pt1);
            leaseRepository.save(leasedb);

            Lease leasedb2 = new Lease();
            String l2Date1 = "11:11:1998";
            String l2Date2 = "12:12:1998";
            DateTimeFormatter l2formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate l2date = LocalDate.parse(l2Date1, l2formatter);
            LocalDate l2date1 = LocalDate.parse(l2Date2, l2formatter);
            leasedb2.setCustomer(c1);
            leasedb2.setDateStart(l2date);
            leasedb2.setDateEnd(l2date1);
            leasedb2.setStatus("not paid");
            leasedb2.setStaff(st1);
            leasedb2.setProduct(pt1);
            leaseRepository.save(leasedb2);

            Lease leasedb3 = new Lease();
            String l2Date12 = "07:07:1998";
            String l2Date22 = "06:07:1998";
            DateTimeFormatter l2formatter2 = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate l2date2 = LocalDate.parse(l2Date12, l2formatter2);
            LocalDate l2date12 = LocalDate.parse(l2Date22, l2formatter2);
            leasedb3.setCustomer(c2);
            leasedb3.setDateStart(l2date2);
            leasedb3.setDateEnd(l2date12);
            leasedb3.setStatus("not paid");
            leasedb3.setStaff(st1);
            leasedb3.setProduct(pt1);
            leaseRepository.save(leasedb3);

            Selling sellingdb = new Selling();
            sellingRepository.save(sellingdb);
            String sDate2 = "20:04:1998";
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate sdate = LocalDate.parse(sDate2, formatter2);

            sellingdb.setSellingDate(sdate);
            sellingdb.setCustomer(c2);
            sellingdb.setStaff(st1);
            sellingdb.setStatus("not paid");
            sellingdb.setProduct(pt1);
            sellingRepository.save(sellingdb);

            Lease lid = leaseRepository.findByLeaseId(1L);
            Booking b1 = bookingRepository.findByBookingId(1L);

            PayMent paymentdb = new PayMent();
            Date paydate = new Date();
            paymentdb.setPmId(1L);
            paymentdb.setBillPayment("BillPayment1");
            paymentdb.setTypePay("Renting");
            paymentdb.setStatusPay("paid");
            paymentdb.setCustomer(c1);
            paymentdb.setDatePay(paydate);
            paymentdb.setLease(lid);
            payMentRepository.save(paymentdb);

    
            Stream.of("การบริการ", "ราคา", "ธุระส่วนตัวของลูกค้า").forEach(typeReasonName -> {
                TypeReason typeReasondb = new TypeReason();
                typeReasondb.setTypeReasonName(typeReasonName);
                if(typeReasonName=="การบริการ"){
                    typeReasondb.setTypeReasonID(1L);
                    typeReasonRepository.save(typeReasondb);
                }else if(typeReasonName=="ราคา"){
                    typeReasondb.setTypeReasonID(2L);
                    typeReasonRepository.save(typeReasondb);
                }else if(typeReasonName=="ธุระส่วนตัวของลูกค้า"){
                    typeReasondb.setTypeReasonID(3L);
                    typeReasonRepository.save(typeReasondb);
            }
            });
            
            TypeReason tr1 = typeReasonRepository.findByTypeReasonID(1L);

            BookingCancle bookingCancledb = new BookingCancle();
            Date bookingCancleDate = new Date();
            bookingCancledb.setBookingCancleID(1L);
            bookingCancledb.setBookingCancleIDs("Bc1");
            bookingCancledb.setBookingCancleDate(bookingCancleDate);
            bookingCancledb.setBookingCancleStatus("cancled");
            bookingCancledb.setBookingCancleReason("เพราะไม่ว่าง");
            bookingCancledb.setBooking(b1);
            bookingCancledb.setTypeReason(tr1);
            bookingCancleRepository.save(bookingCancledb);

            System.out.println("\n Spring-Boot Complete");
        };
    }
}