-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;
-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
                                id uuid NOT NULL,
                                "name" varchar(255) NULL,
                                price numeric(38, 2) NULL,
                                quantity int4 NULL,
                                CONSTRAINT product_pkey PRIMARY KEY (id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
                              id uuid NOT NULL,
                              "name" varchar(255) NULL,
                              surname varchar(255) NULL,
                              CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- public.cart definition

-- Drop table

-- DROP TABLE public.cart;

CREATE TABLE public.cart (
                             id uuid NOT NULL,
                             user_id uuid NOT NULL,
                             CONSTRAINT cart_pkey PRIMARY KEY (id),
                             CONSTRAINT fkg5uhi8vpsuy0lgloxk2h4w5o6 FOREIGN KEY (user_id) REFERENCES public.users(id)
);


-- public.cart_product definition

-- Drop table

-- DROP TABLE public.cart_product;

CREATE TABLE public.cart_product (
                                     cart_id uuid NOT NULL,
                                     product_id uuid NOT NULL,
                                     CONSTRAINT cart_product_pkey PRIMARY KEY (cart_id, product_id),
                                     CONSTRAINT fk2kdlr8hs2bwl14u8oop49vrxi FOREIGN KEY (product_id) REFERENCES public.product(id),
                                     CONSTRAINT fklv5x4iresnv4xspvomrwd8ej9 FOREIGN KEY (cart_id) REFERENCES public.cart(id)
);
