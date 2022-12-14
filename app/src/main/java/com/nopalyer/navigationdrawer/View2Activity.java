package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class View2Activity extends AppCompatActivity {

    private static final String TAG = "AdminActivity";
    private TextView name,faname,rolln,dobn,semtr,catg,acyr,room,deppp,prog,cressadd,pin1,peradd,pin2,mob2,hostel,sem,labsum,creditsum,course;
    private TextView code1,course1,lab1,credit1,code2,course2,lab2,credit2,code3,course3,lab3,credit3,code4,course4,lab4,credit4,code5,course5,lab5,credit5;
    private TextView code6,course6,lab6,credit6,code7,course7,lab7,credit7,code8,course8,lab8,credit8,code9,course9,lab9,credit9,code10,course10,lab10,credit10;
    private TextView cg1,sg1,rep1,cg2,sg2,rep2,cg3,sg3,rep3,cg4,sg4,rep4,cg5,sg5,rep5,cg6,sg6,rep6,cg7,sg7,rep7,cg8,sg8,rep8,cg9,sg9,rep9;
    Bundle bundle;
    private Button upload,edit,next;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog mProgress,pd;
    private FirebaseDatabase database;
    private DatabaseReference ref,mref,ref2;
    private Toolbar toolbar;
    String yr = "",dep = "",roll = "",type ="";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Review Form");
        toolbar.setTitleTextColor(Color.WHITE);

        UI();
        bundle = getIntent().getExtras();

        ActivityCompat.requestPermissions(View2Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        mProgress = new ProgressDialog(View2Activity.this);
        pd = new ProgressDialog(View2Activity.this);


        pd.setMessage("Wait");
        pd.show();
        type = Objects.requireNonNull(bundle.get("type")).toString();
        course.setText(Objects.requireNonNull(bundle.get("type")).toString());
        name.setText(Objects.requireNonNull(bundle.get("Name")).toString());
        faname.setText(Objects.requireNonNull(bundle.get("FatherName")).toString());
        rolln.setText(Objects.requireNonNull(bundle.get("RollNo")).toString());
        dobn.setText(Objects.requireNonNull(bundle.get("Date Of Birth")).toString());
        semtr.setText(Objects.requireNonNull(bundle.get("Email Address")).toString());
        hostel.setText(Objects.requireNonNull(bundle.get("hostel")).toString());
        sem.setText(Objects.requireNonNull(bundle.get("sem")).toString());
        catg.setText(Objects.requireNonNull(bundle.get("Mobile No. 1")).toString());
        acyr.setText(Objects.requireNonNull(bundle.get("Academic Year")).toString());
        room.setText(Objects.requireNonNull(bundle.get("Room")).toString());
        deppp.setText(Objects.requireNonNull(bundle.get("Dep")).toString());
        prog.setText(Objects.requireNonNull(bundle.get("Prog")).toString());
        cressadd.setText(Objects.requireNonNull(bundle.get("Coress")).toString());
        pin1.setText(Objects.requireNonNull(bundle.get("pin1")).toString());
        pin2.setText(Objects.requireNonNull(bundle.get("pin2")).toString());
        peradd.setText(Objects.requireNonNull(bundle.get("perma")).toString());
        mob2.setText(Objects.requireNonNull(bundle.get("Mobile No. 2")).toString());
        code1.setText(Objects.requireNonNull(bundle.get("code1")).toString());
        course1.setText(Objects.requireNonNull(bundle.get("course1")).toString());
        lab1.setText(Objects.requireNonNull(bundle.get("lab1")).toString());
        credit1.setText(Objects.requireNonNull(bundle.get("credit1")).toString());
        code2.setText(Objects.requireNonNull(bundle.get("code2")).toString());
        course2.setText(Objects.requireNonNull(bundle.get("course2")).toString());
        lab2.setText(Objects.requireNonNull(bundle.get("lab2")).toString());
        credit2.setText(Objects.requireNonNull(bundle.get("credit2")).toString());
        code3.setText(Objects.requireNonNull(bundle.get("code3")).toString());
        course3.setText(Objects.requireNonNull(bundle.get("course3")).toString());
        lab3.setText(Objects.requireNonNull(bundle.get("lab3")).toString());
        credit3.setText(Objects.requireNonNull(bundle.get("credit3")).toString());
        code4.setText(Objects.requireNonNull(bundle.get("code4")).toString());
        course4.setText(Objects.requireNonNull(bundle.get("course4")).toString());
        lab4.setText(Objects.requireNonNull(bundle.get("lab4")).toString());
        credit4.setText(Objects.requireNonNull(bundle.get("credit4")).toString());
        code5.setText(Objects.requireNonNull(bundle.get("code5")).toString());
        course5.setText(Objects.requireNonNull(bundle.get("course5")).toString());
        lab5.setText(Objects.requireNonNull(bundle.get("lab5")).toString());
        credit5.setText(Objects.requireNonNull(bundle.get("credit5")).toString());
        code6.setText(Objects.requireNonNull(bundle.get("code6")).toString());
        course6.setText(Objects.requireNonNull(bundle.get("course6")).toString());
        lab6.setText(Objects.requireNonNull(bundle.get("lab6")).toString());
        credit6.setText(Objects.requireNonNull(bundle.get("credit6")).toString());
        code7.setText(Objects.requireNonNull(bundle.get("code7")).toString());
        course7.setText(Objects.requireNonNull(bundle.get("course7")).toString());
        lab7.setText(Objects.requireNonNull(bundle.get("lab7")).toString());
        credit7.setText(Objects.requireNonNull(bundle.get("credit7")).toString());
        code8.setText(Objects.requireNonNull(bundle.get("code8")).toString());
        course8.setText(Objects.requireNonNull(bundle.get("course8")).toString());
        lab8.setText(Objects.requireNonNull(bundle.get("lab8")).toString());
        credit8.setText(Objects.requireNonNull(bundle.get("credit8")).toString());
        code9.setText(Objects.requireNonNull(bundle.get("code9")).toString());
        course9.setText(Objects.requireNonNull(bundle.get("course9")).toString());
        lab9.setText(Objects.requireNonNull(bundle.get("lab9")).toString());
        credit9.setText(Objects.requireNonNull(bundle.get("credit9")).toString());
        code10.setText(Objects.requireNonNull(bundle.get("code10")).toString());
        course10.setText(Objects.requireNonNull(bundle.get("course10")).toString());
        lab10.setText(Objects.requireNonNull(bundle.get("lab10")).toString());
        credit10.setText(Objects.requireNonNull(bundle.get("credit10")).toString());
        labsum.setText(Objects.requireNonNull(bundle.get("labsum")).toString());
        creditsum.setText(Objects.requireNonNull(bundle.get("creditsum")).toString());
        cg1.setText(Objects.requireNonNull(bundle.get("cg1")).toString());
        sg1.setText(Objects.requireNonNull(bundle.get("sg1")).toString());
        rep1.setText(Objects.requireNonNull(bundle.get("rep1")).toString());
        cg2.setText(Objects.requireNonNull(bundle.get("cg2")).toString());
        sg2.setText(Objects.requireNonNull(bundle.get("sg2")).toString());
        rep2.setText(Objects.requireNonNull(bundle.get("rep2")).toString());
        cg3.setText(Objects.requireNonNull(bundle.get("cg3")).toString());
        sg3.setText(Objects.requireNonNull(bundle.get("sg3")).toString());
        rep3.setText(Objects.requireNonNull(bundle.get("rep3")).toString());
        cg4.setText(Objects.requireNonNull(bundle.get("cg4")).toString());
        sg4.setText(Objects.requireNonNull(bundle.get("sg4")).toString());
        rep4.setText(Objects.requireNonNull(bundle.get("rep4")).toString());
        cg5.setText(Objects.requireNonNull(bundle.get("cg5")).toString());
        sg5.setText(Objects.requireNonNull(bundle.get("sg5")).toString());
        rep5.setText(Objects.requireNonNull(bundle.get("rep5")).toString());
        cg6.setText(Objects.requireNonNull(bundle.get("cg6")).toString());
        sg6.setText(Objects.requireNonNull(bundle.get("sg6")).toString());
        rep6.setText(Objects.requireNonNull(bundle.get("rep6")).toString());
        cg7.setText(Objects.requireNonNull(bundle.get("cg7")).toString());
        sg7.setText(Objects.requireNonNull(bundle.get("sg7")).toString());
        rep7.setText(Objects.requireNonNull(bundle.get("rep7")).toString());
        cg8.setText(Objects.requireNonNull(bundle.get("cg8")).toString());
        sg8.setText(Objects.requireNonNull(bundle.get("sg8")).toString());
        rep8.setText(Objects.requireNonNull(bundle.get("rep8")).toString());
        cg9.setText(Objects.requireNonNull(bundle.get("cg9")).toString());
        sg9.setText(Objects.requireNonNull(bundle.get("sg9")).toString());
        rep9.setText(Objects.requireNonNull(bundle.get("rep9")).toString());

        pd.dismiss();


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.setMessage("Wait");
                mProgress.show();
                ref2 = database.getReference(firebaseAuth.getUid());
                ref2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("Profile")){
                            ref = database.getReference(firebaseAuth.getUid()).child("Profile");
                            ref.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    yr = dataSnapshot.child("Year").getValue().toString();
                                    dep = dataSnapshot.child("Department").getValue().toString();
                                    roll = dataSnapshot.child("Roll No").getValue().toString();

                                    mref = database.getReference( "LateApplication").child(type).child(yr).child(dep).child(roll);
                                    mref.child("Course").setValue(type);
                                    mref.child("Name").setValue(name.getText().toString());
                                    mref.child("FatherName").setValue(faname.getText().toString());
                                    mref.child("RollNo").setValue(rolln.getText().toString());
                                    mref.child("DOB").setValue(dobn.getText().toString());
                                    mref.child("Email").setValue(semtr.getText().toString());
                                    mref.child("Mobile1").setValue(catg.getText().toString());
                                    mref.child("AcademicYear").setValue(acyr.getText().toString());
                                    mref.child("Room").setValue(room.getText().toString());
                                    mref.child("Programme").setValue(prog.getText().toString());
                                    mref.child("Department").setValue(deppp.getText().toString());
                                    mref.child("CorresspondingAddress").setValue(cressadd.getText().toString());
                                    mref.child("Pin1").setValue(pin1.getText().toString());
                                    mref.child("PermanentAddress").setValue(peradd.getText().toString());
                                    mref.child("Pin2").setValue(pin2.getText().toString());
                                    mref.child("Mobile2").setValue(mob2.getText().toString());
                                    mref.child("Hostel").setValue(hostel.getText().toString());
                                    mref.child("Semester").setValue(sem.getText().toString());
                                    mref.child("Sub1").setValue(code1.getText().toString());
                                    mref.child("Course1").setValue(course1.getText().toString());
                                    mref.child("Lab1").setValue(lab1.getText().toString());
                                    mref.child("Credit1").setValue(credit1.getText().toString());
                                    mref.child("Sub2").setValue(code2.getText().toString());
                                    mref.child("Course2").setValue(course2.getText().toString());
                                    mref.child("Lab2").setValue(lab2.getText().toString());
                                    mref.child("Credit2").setValue(credit2.getText().toString());
                                    mref.child("Sub3").setValue(code3.getText().toString());
                                    mref.child("Course3").setValue(course3.getText().toString());
                                    mref.child("Lab3").setValue(lab3.getText().toString());
                                    mref.child("Credit3").setValue(credit3.getText().toString());
                                    mref.child("Sub4").setValue(code4.getText().toString());
                                    mref.child("Course4").setValue(course4.getText().toString());
                                    mref.child("Lab4").setValue(lab4.getText().toString());
                                    mref.child("Credit4").setValue(credit4.getText().toString());
                                    mref.child("Sub5").setValue(code5.getText().toString());
                                    mref.child("Course5").setValue(course5.getText().toString());
                                    mref.child("Lab5").setValue(lab5.getText().toString());
                                    mref.child("Credit5").setValue(credit5.getText().toString());
                                    mref.child("Sub6").setValue(code6.getText().toString());
                                    mref.child("Course6").setValue(course6.getText().toString());
                                    mref.child("Lab6").setValue(lab6.getText().toString());
                                    mref.child("Credit6").setValue(credit6.getText().toString());
                                    mref.child("Sub7").setValue(code7.getText().toString());
                                    mref.child("Course7").setValue(course7.getText().toString());
                                    mref.child("Lab7").setValue(lab7.getText().toString());
                                    mref.child("Credit7").setValue(credit7.getText().toString());
                                    mref.child("Sub8").setValue(code8.getText().toString());
                                    mref.child("Course8").setValue(course8.getText().toString());
                                    mref.child("Lab8").setValue(lab8.getText().toString());
                                    mref.child("Credit8").setValue(credit8.getText().toString());
                                    mref.child("Sub9").setValue(code9.getText().toString());
                                    mref.child("Course9").setValue(course9.getText().toString());
                                    mref.child("Lab9").setValue(lab9.getText().toString());
                                    mref.child("Credit9").setValue(credit9.getText().toString());
                                    mref.child("Sub10").setValue(code10.getText().toString());
                                    mref.child("Course10").setValue(course10.getText().toString());
                                    mref.child("Lab10").setValue(lab10.getText().toString());
                                    mref.child("Credit10").setValue(credit10.getText().toString());
                                    mref.child("CreditSum").setValue(creditsum.getText().toString());
                                    mref.child("LabSum").setValue(labsum.getText().toString());
                                    mref.child("cg1").setValue(cg1.getText().toString());
                                    mref.child("sg1").setValue(sg1.getText().toString());
                                    mref.child("rep1").setValue(rep1.getText().toString());
                                    mref.child("cg2").setValue(cg2.getText().toString());
                                    mref.child("sg2").setValue(sg2.getText().toString());
                                    mref.child("rep2").setValue(rep2.getText().toString());
                                    mref.child("cg3").setValue(cg3.getText().toString());
                                    mref.child("sg3").setValue(sg3.getText().toString());
                                    mref.child("rep3").setValue(rep3.getText().toString());
                                    mref.child("cg4").setValue(cg4.getText().toString());
                                    mref.child("sg4").setValue(sg4.getText().toString());
                                    mref.child("rep4").setValue(rep4.getText().toString());
                                    mref.child("cg5").setValue(cg5.getText().toString());
                                    mref.child("sg5").setValue(sg5.getText().toString());
                                    mref.child("rep5").setValue(rep5.getText().toString());
                                    mref.child("cg6").setValue(cg6.getText().toString());
                                    mref.child("sg6").setValue(sg6.getText().toString());
                                    mref.child("rep6").setValue(rep6.getText().toString());
                                    mref.child("cg7").setValue(cg7.getText().toString());
                                    mref.child("sg7").setValue(sg7.getText().toString());
                                    mref.child("rep7").setValue(rep7.getText().toString());
                                    mref.child("cg8").setValue(cg8.getText().toString());
                                    mref.child("sg8").setValue(sg8.getText().toString());
                                    mref.child("rep8").setValue(rep8.getText().toString());
                                    mref.child("cg9").setValue(cg9.getText().toString());
                                    mref.child("sg9").setValue(sg9.getText().toString());
                                    mref.child("rep9").setValue(rep9.getText().toString());

                                    mProgress.dismiss();
                                    Toast.makeText(View2Activity.this,"Upload Done",Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(View2Activity.this,Upload2Doument.class);
                                    i.putExtra("type",type);
                                    startActivity(i);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                    Toast.makeText(View2Activity.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else{
                            Toast.makeText(View2Activity.this,"Complete Your profile",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View2Activity.this,Btech_registration.class));
            }
        });


    }

    private void  UI(){
        name = (TextView)findViewById(R.id.regtvNamelate);
        faname = (TextView)findViewById(R.id.regtvFatherlate);
        rolln = (TextView)findViewById(R.id.regtvrolllate);
        dobn = (TextView)findViewById(R.id.regtvDoblate);
        semtr = (TextView)findViewById(R.id.regtvSemlate);
        catg = (TextView)findViewById(R.id.regtvCategorylate);
        room = (TextView)findViewById(R.id.regtvroomlate);
        deppp = (TextView)findViewById(R.id.regtvdeplate);
        prog = (TextView)findViewById(R.id.regtvproglate);
        pin1 = (TextView)findViewById(R.id.regtvPin1late);
        cressadd = (TextView)findViewById(R.id.regtvCrreslate);
        peradd = (TextView)findViewById(R.id.regtvPerlate);
        pin2 = (TextView)findViewById(R.id.regtvPin2late);
        mob2 = (TextView)findViewById(R.id.regtvmob2late);
        hostel = (TextView)findViewById(R.id.regtvhostellate);
        sem = (TextView)findViewById(R.id.regtvSemesterlate);
        code1 = (TextView)findViewById(R.id.code1vlate);
        course1 = (TextView)findViewById(R.id.course1vlate);
        lab1 = (TextView)findViewById(R.id.lab1vlate);
        credit1 = (TextView)findViewById(R.id.credit1vlate);
        code2 = (TextView)findViewById(R.id.code2vlate);
        course2 = (TextView)findViewById(R.id.course2vlate);
        lab2 = (TextView)findViewById(R.id.lab2vlate);
        credit2 = (TextView)findViewById(R.id.credit2vlate);
        code3 = (TextView)findViewById(R.id.code3vlate);
        course3 = (TextView)findViewById(R.id.course3vlate);
        lab3 = (TextView)findViewById(R.id.lab3vlate);
        credit3 = (TextView)findViewById(R.id.credit3vlate);
        code4 = (TextView)findViewById(R.id.code4vlate);
        course4 = (TextView)findViewById(R.id.course4vlate);
        lab4 = (TextView)findViewById(R.id.lab4vlate);
        credit4 = (TextView)findViewById(R.id.credit4vlate);
        code5 = (TextView)findViewById(R.id.code5vlate);
        course5 = (TextView)findViewById(R.id.course5vlate);
        lab5 = (TextView)findViewById(R.id.lab5vlate);
        credit5 = (TextView)findViewById(R.id.credit5vlate);
        code6 = (TextView)findViewById(R.id.code6vlate);
        course6 = (TextView)findViewById(R.id.course6vlate);
        lab6 = (TextView)findViewById(R.id.lab6vlate);
        credit6 = (TextView)findViewById(R.id.credit6vlate);
        code7 = (TextView)findViewById(R.id.code7vlate);
        course7 = (TextView)findViewById(R.id.course7vlate);
        lab7 = (TextView)findViewById(R.id.lab7vlate);
        credit7 = (TextView)findViewById(R.id.credit7vlate);
        code8 = (TextView)findViewById(R.id.code8vlate);
        course8 = (TextView)findViewById(R.id.course8vlate);
        lab8 = (TextView)findViewById(R.id.lab8vlate);
        credit8 = (TextView)findViewById(R.id.credit8vlate);
        code9 = (TextView)findViewById(R.id.code9vlate);
        course9 = (TextView)findViewById(R.id.course9vlate);
        lab9 = (TextView)findViewById(R.id.lab9vlate);
        credit9 = (TextView)findViewById(R.id.credit9vlate);
        code10 = (TextView)findViewById(R.id.code10vlate);
        course10 = (TextView)findViewById(R.id.course10vlate);
        lab10 = (TextView)findViewById(R.id.lab10vlate);
        credit10 = (TextView)findViewById(R.id.credit10vlate);
        labsum = (TextView)findViewById(R.id.labsumvlate);
        creditsum = (TextView)findViewById(R.id.creditsumvlate);
        sg1 =  findViewById(R.id.sg1vlate);
        sg2 =  findViewById(R.id.sg2vlate);
        sg3 =  findViewById(R.id.sg3vlate);
        sg4 =  findViewById(R.id.sg4vlate);
        sg5 =  findViewById(R.id.sg5vlate);
        sg6 =  findViewById(R.id.sg6vlate);
        sg7 =  findViewById(R.id.sg7vlate);
        sg8 =  findViewById(R.id.sg8vlate);
        sg9 =  findViewById(R.id.sg9vlate);
        cg1 =  findViewById(R.id.cg1vlate);
        cg2 =  findViewById(R.id.cg2vlate);
        cg3 =  findViewById(R.id.cg3vlate);
        cg4 =  findViewById(R.id.cg4vlate);
        cg5 =  findViewById(R.id.cg5vlate);
        cg6 =  findViewById(R.id.cg6vlate);
        cg7 =  findViewById(R.id.cg7vlate);
        cg8 = findViewById(R.id.cg8vlate);
        cg9 =  findViewById(R.id.cg9vlate);
        rep1 =  findViewById(R.id.rep1vlate);
        rep2 =  findViewById(R.id.rep2vlate);
        rep3 = findViewById(R.id.rep3vlate);
        rep4 =  findViewById(R.id.rep4vlate);
        rep5 =  findViewById(R.id.rep5vlate);
        rep6 =  findViewById(R.id.rep6vlate);
        rep7 =  findViewById(R.id.rep7vlate);
        rep8 = findViewById(R.id.rep8vlate);
        rep9 = findViewById(R.id.rep9vlate);
        course = findViewById(R.id.regtvcourse);


        acyr = findViewById(R.id.regtvAcyrlate);
        upload = (Button)findViewById(R.id.regaddpdflate);
        edit = (Button)findViewById(R.id.regeditlate);
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }
}