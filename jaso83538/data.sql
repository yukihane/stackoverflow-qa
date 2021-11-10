-- NO_ZERO_DATE を外す
set session sql_mode='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

create table SHAIN (
    TAISHABI DATETIME,
    COLUMN1 varchar(255),
    COLUMN2 varchar(255),
    id bigint primary key
);

insert into SHAIN (id, COLUMN1, COLUMN2, TAISHABI) values
(1, 'shain1-1', 'shain1-2', null),
(2, 'shain2-1', 'shain2-2', '2021-10-01'),
(3, 'shain3-1', 'shain3-2', '2022-10-01'),
(4, 'shain4-1', 'shain4-2', '0000-00-00');

-- NO_ZERO_DATE を追加設定
set session sql_mode='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- select は通る
select * from SHAIN
where
  DATE_FORMAT(NOW(), '%Y%m%d') < DATE_FORMAT(LAST_DAY(TAISHABI), '%Y%m%d');

-- update は通らない
UPDATE SHAIN
SET
  COLUMN1 = COLUMN2
WHERE
  DATE_FORMAT(NOW(), '%Y%m%d') < DATE_FORMAT(LAST_DAY(TAISHABI), '%Y%m%d');
