PGDMP     3    0                z            pc_toplama1    14.2    14.2 K    W           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            X           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            Y           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            Z           1262    16667    pc_toplama1    DATABASE     h   CREATE DATABASE pc_toplama1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE pc_toplama1;
                postgres    false            ?            1259    16760    anakart    TABLE     ?   CREATE TABLE public.anakart (
    urun_id integer NOT NULL,
    kampanya_id integer,
    cpu_soketi_markasi character varying,
    bellek_saat_hizi integer,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.anakart;
       public         heap    postgres    false            ?            1259    16676    bilgisayar_bileseni    TABLE     ?   CREATE TABLE public.bilgisayar_bileseni (
    urun_id integer NOT NULL,
    kampanya_id integer,
    marka character varying,
    indirim_yuzdesi double precision,
    stok integer
);
 '   DROP TABLE public.bilgisayar_bileseni;
       public         heap    postgres    false            ?            1259    16675    bilgisayar_bileseni_urun_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.bilgisayar_bileseni_urun_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.bilgisayar_bileseni_urun_id_seq;
       public          postgres    false    212            [           0    0    bilgisayar_bileseni_urun_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.bilgisayar_bileseni_urun_id_seq OWNED BY public.bilgisayar_bileseni.urun_id;
          public          postgres    false    211            ?            1259    16794    ekran_karti    TABLE     ?   CREATE TABLE public.ekran_karti (
    urun_id integer NOT NULL,
    kampanya_id integer,
    model character varying,
    bellek integer,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.ekran_karti;
       public         heap    postgres    false            ?            1259    16811    islemci    TABLE     ?   CREATE TABLE public.islemci (
    urun_id integer NOT NULL,
    kampanya_id integer,
    cekirdek_sayisi integer,
    hiz integer,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.islemci;
       public         heap    postgres    false            ?            1259    16669    kampanya    TABLE     i   CREATE TABLE public.kampanya (
    kampanya_id integer NOT NULL,
    indirim_yuzdesi double precision
);
    DROP TABLE public.kampanya;
       public         heap    postgres    false            ?            1259    16668    kampanya_kampanya_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kampanya_kampanya_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.kampanya_kampanya_id_seq;
       public          postgres    false    210            \           0    0    kampanya_kampanya_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.kampanya_kampanya_id_seq OWNED BY public.kampanya.kampanya_id;
          public          postgres    false    209            ?            1259    16828    kasa    TABLE     ?   CREATE TABLE public.kasa (
    urun_id integer NOT NULL,
    kampanya_id integer,
    boyut character varying,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.kasa;
       public         heap    postgres    false            ?            1259    16743    klavye    TABLE     ?   CREATE TABLE public.klavye (
    urun_id integer NOT NULL,
    kampanya_id integer,
    switch_modeli character varying,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.klavye;
       public         heap    postgres    false            ?            1259    16699 	   kullanici    TABLE     ?   CREATE TABLE public.kullanici (
    kullanici_id integer NOT NULL,
    ad_soyad character varying,
    sifre character varying
);
    DROP TABLE public.kullanici;
       public         heap    postgres    false            ?            1259    16698    kullanici_kullanici_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kullanici_kullanici_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.kullanici_kullanici_id_seq;
       public          postgres    false    214            ]           0    0    kullanici_kullanici_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.kullanici_kullanici_id_seq OWNED BY public.kullanici.kullanici_id;
          public          postgres    false    213            ?            1259    16845    monitor    TABLE     ?   CREATE TABLE public.monitor (
    urun_id integer NOT NULL,
    kampanya_id integer,
    boyut integer,
    ekran_yenileme_hizi integer,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.monitor;
       public         heap    postgres    false            ?            1259    16777    mouse    TABLE     ?   CREATE TABLE public.mouse (
    urun_id integer NOT NULL,
    kampanya_id integer,
    baglanma_sekli character varying,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.mouse;
       public         heap    postgres    false            ?            1259    16726    ram    TABLE     ?   CREATE TABLE public.ram (
    urun_id integer NOT NULL,
    kampanya_id integer,
    bellek integer,
    marka character varying,
    fiyat double precision,
    stok integer
);
    DROP TABLE public.ram;
       public         heap    postgres    false            ?            1259    16708    siparis_verir    TABLE     ?   CREATE TABLE public.siparis_verir (
    siparis_id integer NOT NULL,
    kullanici_id integer,
    urun_id integer,
    tutar double precision,
    tarih character varying
);
 !   DROP TABLE public.siparis_verir;
       public         heap    postgres    false            ?            1259    16707    siparis_verir_siparis_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.siparis_verir_siparis_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.siparis_verir_siparis_id_seq;
       public          postgres    false    216            ^           0    0    siparis_verir_siparis_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.siparis_verir_siparis_id_seq OWNED BY public.siparis_verir.siparis_id;
          public          postgres    false    215            ?           2604    16679    bilgisayar_bileseni urun_id    DEFAULT     ?   ALTER TABLE ONLY public.bilgisayar_bileseni ALTER COLUMN urun_id SET DEFAULT nextval('public.bilgisayar_bileseni_urun_id_seq'::regclass);
 J   ALTER TABLE public.bilgisayar_bileseni ALTER COLUMN urun_id DROP DEFAULT;
       public          postgres    false    212    211    212            ?           2604    16672    kampanya kampanya_id    DEFAULT     |   ALTER TABLE ONLY public.kampanya ALTER COLUMN kampanya_id SET DEFAULT nextval('public.kampanya_kampanya_id_seq'::regclass);
 C   ALTER TABLE public.kampanya ALTER COLUMN kampanya_id DROP DEFAULT;
       public          postgres    false    209    210    210            ?           2604    16702    kullanici kullanici_id    DEFAULT     ?   ALTER TABLE ONLY public.kullanici ALTER COLUMN kullanici_id SET DEFAULT nextval('public.kullanici_kullanici_id_seq'::regclass);
 E   ALTER TABLE public.kullanici ALTER COLUMN kullanici_id DROP DEFAULT;
       public          postgres    false    213    214    214            ?           2604    16711    siparis_verir siparis_id    DEFAULT     ?   ALTER TABLE ONLY public.siparis_verir ALTER COLUMN siparis_id SET DEFAULT nextval('public.siparis_verir_siparis_id_seq'::regclass);
 G   ALTER TABLE public.siparis_verir ALTER COLUMN siparis_id DROP DEFAULT;
       public          postgres    false    215    216    216            O          0    16760    anakart 
   TABLE DATA           q   COPY public.anakart (urun_id, kampanya_id, cpu_soketi_markasi, bellek_saat_hizi, marka, fiyat, stok) FROM stdin;
    public          postgres    false    219   ?]       H          0    16676    bilgisayar_bileseni 
   TABLE DATA           a   COPY public.bilgisayar_bileseni (urun_id, kampanya_id, marka, indirim_yuzdesi, stok) FROM stdin;
    public          postgres    false    212   ?]       Q          0    16794    ekran_karti 
   TABLE DATA           ^   COPY public.ekran_karti (urun_id, kampanya_id, model, bellek, marka, fiyat, stok) FROM stdin;
    public          postgres    false    221   ^       R          0    16811    islemci 
   TABLE DATA           a   COPY public.islemci (urun_id, kampanya_id, cekirdek_sayisi, hiz, marka, fiyat, stok) FROM stdin;
    public          postgres    false    222   -^       F          0    16669    kampanya 
   TABLE DATA           @   COPY public.kampanya (kampanya_id, indirim_yuzdesi) FROM stdin;
    public          postgres    false    210   J^       S          0    16828    kasa 
   TABLE DATA           O   COPY public.kasa (urun_id, kampanya_id, boyut, marka, fiyat, stok) FROM stdin;
    public          postgres    false    223   g^       N          0    16743    klavye 
   TABLE DATA           Y   COPY public.klavye (urun_id, kampanya_id, switch_modeli, marka, fiyat, stok) FROM stdin;
    public          postgres    false    218   ?^       J          0    16699 	   kullanici 
   TABLE DATA           B   COPY public.kullanici (kullanici_id, ad_soyad, sifre) FROM stdin;
    public          postgres    false    214   ?^       T          0    16845    monitor 
   TABLE DATA           g   COPY public.monitor (urun_id, kampanya_id, boyut, ekran_yenileme_hizi, marka, fiyat, stok) FROM stdin;
    public          postgres    false    224   ?^       P          0    16777    mouse 
   TABLE DATA           Y   COPY public.mouse (urun_id, kampanya_id, baglanma_sekli, marka, fiyat, stok) FROM stdin;
    public          postgres    false    220   ?^       M          0    16726    ram 
   TABLE DATA           O   COPY public.ram (urun_id, kampanya_id, bellek, marka, fiyat, stok) FROM stdin;
    public          postgres    false    217   ?^       L          0    16708    siparis_verir 
   TABLE DATA           X   COPY public.siparis_verir (siparis_id, kullanici_id, urun_id, tutar, tarih) FROM stdin;
    public          postgres    false    216   _       _           0    0    bilgisayar_bileseni_urun_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.bilgisayar_bileseni_urun_id_seq', 1, false);
          public          postgres    false    211            `           0    0    kampanya_kampanya_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.kampanya_kampanya_id_seq', 1, false);
          public          postgres    false    209            a           0    0    kullanici_kullanici_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.kullanici_kullanici_id_seq', 1, false);
          public          postgres    false    213            b           0    0    siparis_verir_siparis_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.siparis_verir_siparis_id_seq', 1, false);
          public          postgres    false    215            ?           2606    16766    anakart anakart_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.anakart
    ADD CONSTRAINT anakart_pkey PRIMARY KEY (urun_id);
 >   ALTER TABLE ONLY public.anakart DROP CONSTRAINT anakart_pkey;
       public            postgres    false    219            ?           2606    16683 ,   bilgisayar_bileseni bilgisayar_bileseni_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.bilgisayar_bileseni
    ADD CONSTRAINT bilgisayar_bileseni_pkey PRIMARY KEY (urun_id);
 V   ALTER TABLE ONLY public.bilgisayar_bileseni DROP CONSTRAINT bilgisayar_bileseni_pkey;
       public            postgres    false    212            ?           2606    16800    ekran_karti ekran_karti_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.ekran_karti
    ADD CONSTRAINT ekran_karti_pkey PRIMARY KEY (urun_id);
 F   ALTER TABLE ONLY public.ekran_karti DROP CONSTRAINT ekran_karti_pkey;
       public            postgres    false    221            ?           2606    16817    islemci islemci_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.islemci
    ADD CONSTRAINT islemci_pkey PRIMARY KEY (urun_id);
 >   ALTER TABLE ONLY public.islemci DROP CONSTRAINT islemci_pkey;
       public            postgres    false    222            ?           2606    16674    kampanya kampanya_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.kampanya
    ADD CONSTRAINT kampanya_pkey PRIMARY KEY (kampanya_id);
 @   ALTER TABLE ONLY public.kampanya DROP CONSTRAINT kampanya_pkey;
       public            postgres    false    210            ?           2606    16834    kasa kasa_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.kasa
    ADD CONSTRAINT kasa_pkey PRIMARY KEY (urun_id);
 8   ALTER TABLE ONLY public.kasa DROP CONSTRAINT kasa_pkey;
       public            postgres    false    223            ?           2606    16749    klavye klavye_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.klavye
    ADD CONSTRAINT klavye_pkey PRIMARY KEY (urun_id);
 <   ALTER TABLE ONLY public.klavye DROP CONSTRAINT klavye_pkey;
       public            postgres    false    218            ?           2606    16706    kullanici kullanici_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT kullanici_pkey PRIMARY KEY (kullanici_id);
 B   ALTER TABLE ONLY public.kullanici DROP CONSTRAINT kullanici_pkey;
       public            postgres    false    214            ?           2606    16851    monitor monitor_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_pkey PRIMARY KEY (urun_id);
 >   ALTER TABLE ONLY public.monitor DROP CONSTRAINT monitor_pkey;
       public            postgres    false    224            ?           2606    16783    mouse mouse_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.mouse
    ADD CONSTRAINT mouse_pkey PRIMARY KEY (urun_id);
 :   ALTER TABLE ONLY public.mouse DROP CONSTRAINT mouse_pkey;
       public            postgres    false    220            ?           2606    16732    ram ram_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.ram
    ADD CONSTRAINT ram_pkey PRIMARY KEY (urun_id);
 6   ALTER TABLE ONLY public.ram DROP CONSTRAINT ram_pkey;
       public            postgres    false    217            ?           2606    16715     siparis_verir siparis_verir_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.siparis_verir
    ADD CONSTRAINT siparis_verir_pkey PRIMARY KEY (siparis_id);
 J   ALTER TABLE ONLY public.siparis_verir DROP CONSTRAINT siparis_verir_pkey;
       public            postgres    false    216            ?           2606    16772     anakart anakart_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.anakart
    ADD CONSTRAINT anakart_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 J   ALTER TABLE ONLY public.anakart DROP CONSTRAINT anakart_kampanya_id_fkey;
       public          postgres    false    210    219    3216            ?           2606    16767    anakart anakart_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.anakart
    ADD CONSTRAINT anakart_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 F   ALTER TABLE ONLY public.anakart DROP CONSTRAINT anakart_urun_id_fkey;
       public          postgres    false    3218    219    212            ?           2606    16684 8   bilgisayar_bileseni bilgisayar_bileseni_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.bilgisayar_bileseni
    ADD CONSTRAINT bilgisayar_bileseni_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 b   ALTER TABLE ONLY public.bilgisayar_bileseni DROP CONSTRAINT bilgisayar_bileseni_kampanya_id_fkey;
       public          postgres    false    3216    210    212            ?           2606    16806 (   ekran_karti ekran_karti_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ekran_karti
    ADD CONSTRAINT ekran_karti_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 R   ALTER TABLE ONLY public.ekran_karti DROP CONSTRAINT ekran_karti_kampanya_id_fkey;
       public          postgres    false    210    221    3216            ?           2606    16801 $   ekran_karti ekran_karti_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ekran_karti
    ADD CONSTRAINT ekran_karti_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 N   ALTER TABLE ONLY public.ekran_karti DROP CONSTRAINT ekran_karti_urun_id_fkey;
       public          postgres    false    221    3218    212            ?           2606    16823     islemci islemci_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.islemci
    ADD CONSTRAINT islemci_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 J   ALTER TABLE ONLY public.islemci DROP CONSTRAINT islemci_kampanya_id_fkey;
       public          postgres    false    3216    222    210            ?           2606    16818    islemci islemci_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.islemci
    ADD CONSTRAINT islemci_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 F   ALTER TABLE ONLY public.islemci DROP CONSTRAINT islemci_urun_id_fkey;
       public          postgres    false    3218    222    212            ?           2606    16840    kasa kasa_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kasa
    ADD CONSTRAINT kasa_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 D   ALTER TABLE ONLY public.kasa DROP CONSTRAINT kasa_kampanya_id_fkey;
       public          postgres    false    210    3216    223            ?           2606    16835    kasa kasa_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kasa
    ADD CONSTRAINT kasa_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 @   ALTER TABLE ONLY public.kasa DROP CONSTRAINT kasa_urun_id_fkey;
       public          postgres    false    212    223    3218            ?           2606    16755    klavye klavye_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.klavye
    ADD CONSTRAINT klavye_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 H   ALTER TABLE ONLY public.klavye DROP CONSTRAINT klavye_kampanya_id_fkey;
       public          postgres    false    210    218    3216            ?           2606    16750    klavye klavye_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.klavye
    ADD CONSTRAINT klavye_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 D   ALTER TABLE ONLY public.klavye DROP CONSTRAINT klavye_urun_id_fkey;
       public          postgres    false    218    3218    212            ?           2606    16857     monitor monitor_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 J   ALTER TABLE ONLY public.monitor DROP CONSTRAINT monitor_kampanya_id_fkey;
       public          postgres    false    224    210    3216            ?           2606    16852    monitor monitor_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.monitor
    ADD CONSTRAINT monitor_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 F   ALTER TABLE ONLY public.monitor DROP CONSTRAINT monitor_urun_id_fkey;
       public          postgres    false    212    224    3218            ?           2606    16789    mouse mouse_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mouse
    ADD CONSTRAINT mouse_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 F   ALTER TABLE ONLY public.mouse DROP CONSTRAINT mouse_kampanya_id_fkey;
       public          postgres    false    210    220    3216            ?           2606    16784    mouse mouse_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mouse
    ADD CONSTRAINT mouse_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 B   ALTER TABLE ONLY public.mouse DROP CONSTRAINT mouse_urun_id_fkey;
       public          postgres    false    3218    220    212            ?           2606    16738    ram ram_kampanya_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ram
    ADD CONSTRAINT ram_kampanya_id_fkey FOREIGN KEY (kampanya_id) REFERENCES public.kampanya(kampanya_id);
 B   ALTER TABLE ONLY public.ram DROP CONSTRAINT ram_kampanya_id_fkey;
       public          postgres    false    217    210    3216            ?           2606    16733    ram ram_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ram
    ADD CONSTRAINT ram_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 >   ALTER TABLE ONLY public.ram DROP CONSTRAINT ram_urun_id_fkey;
       public          postgres    false    212    3218    217            ?           2606    16716 -   siparis_verir siparis_verir_kullanici_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.siparis_verir
    ADD CONSTRAINT siparis_verir_kullanici_id_fkey FOREIGN KEY (kullanici_id) REFERENCES public.kullanici(kullanici_id);
 W   ALTER TABLE ONLY public.siparis_verir DROP CONSTRAINT siparis_verir_kullanici_id_fkey;
       public          postgres    false    3220    214    216            ?           2606    16721 (   siparis_verir siparis_verir_urun_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.siparis_verir
    ADD CONSTRAINT siparis_verir_urun_id_fkey FOREIGN KEY (urun_id) REFERENCES public.bilgisayar_bileseni(urun_id);
 R   ALTER TABLE ONLY public.siparis_verir DROP CONSTRAINT siparis_verir_urun_id_fkey;
       public          postgres    false    216    212    3218            O      x?????? ? ?      H      x?????? ? ?      Q      x?????? ? ?      R      x?????? ? ?      F      x?????? ? ?      S      x?????? ? ?      N      x?????? ? ?      J      x?????? ? ?      T      x?????? ? ?      P      x?????? ? ?      M      x?????? ? ?      L      x?????? ? ?     