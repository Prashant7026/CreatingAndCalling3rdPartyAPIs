CREATE TABLE category
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    is_deleted    BIT(1) NULL,
    # change name to category_Name. Now give same attribute name in category model.
    category_Name VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_feature_products
(
    category_id         BIGINT NOT NULL,
    feature_products_id BIGINT NOT NULL
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    is_deleted    BIT(1) NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price DOUBLE NULL,
    image_url     VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE category_feature_products
    ADD CONSTRAINT uc_category_feature_products_featureproducts UNIQUE (feature_products_id);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (category_Name);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_feature_products
    ADD CONSTRAINT fk_catfeapro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_feature_products
    ADD CONSTRAINT fk_catfeapro_on_product FOREIGN KEY (feature_products_id) REFERENCES product (id);