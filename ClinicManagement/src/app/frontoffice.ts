export class FrontOffice {

    regId: number;
    pFName: String;
    pLName: String;
    pGender: String;
    pDOB: Date;
    pAddr: String;
    pPhNo: String;
    pBloodGrp: String;
    createdDateP: Date;
    age: number;

    appId: number;
    dId: number;
    dateOfApp: Date;
    consultStatus: String;


    fBillId: number;
    billDate: Date;
    admFee: number;

    //Dr Table
    sId: number;
    dSpec: String;
    dQualification: String;
    consultFee: number;

    //staff table
    roleId: number;
    sName: String;
    sDOB: Date;
    sGender: String;
    sAddr: String;
    sExp: String;
    sPhNo: String;
    sEmail: String;
    username: String;
    password: String;
    isActiveS: String;
    createdDate: Date;

    //role Table
    roleName: String;

    //day Table
    dayId: number;
    dayName: String;

    //ConsultDay Table
    consultId: number;

    //ConsultDayS Table
    consultDayId: number;

    sun: String;
    mon: String;
    tue: String;
    wed: String;
    thu: String;
    fri: String;
    sat: String;

}