DROP TABLE IF EXISTS applicant, priorization, distribution;

create table applicant
(
    id serial
        constraint applicant_pk
            primary key,
    username varchar not null,
    details json
);

create unique index applicant_username_uindex
    on applicant (username);
create table priorization
(
    id serial
        constraint priorization_pk
            primary key,
    application json,
    priority int
);
create table distribution
(
    module varchar not null
        constraint distribution_pk
            primary key,
    applicants json
);