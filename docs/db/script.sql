create table frequency (frequency_id serial primary key, description varchar);
create table payment_frequency (payment_frequency_id serial primary key, description varchar, frequency_id integer, frequency_value decimal);
create table mortgage_proposal (mortgage_proposal_id serial primary key, goal varchar, purchase_price decimal, down_payment decimal, interest_rate decimal, total_mortgage decimal, amortization_period integer, payment_frequency_id integer, user_id varchar, created_date timestamp); 
create table user_info(user_info_id serial primary key, full_name varchar, birthday date, montly_income decimal, identification_number varchar, occupation varchar);

alter table payment_frequency add constraint fk_payment_frequency_frequency_id foreign key (frequency_id) references frequency (frequency_id);
alter table mortgage_proposal add constraint fk_mortgage_proposal_payment_frequency_id foreign key (payment_frequency_id) references payment_frequency (payment_frequency_id);

insert into public.frequency (description) values ('Monthly');
insert into public.frequency (description) values ('Weekly');