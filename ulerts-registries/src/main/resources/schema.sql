create table emergencyCase(
   id integer not null auto_increment,
   emergencyType varchar(255) not null,
   numberPeopleHurt integer,
   numberCarImplied integer,
   desincarcerateNumber integer,
   ETAPolice date,
   ETAFirefighters date,
   ETAAmbulance date,
   fireState varchar(100),
   matchedSos varchar(100),
   primary key(id)
);