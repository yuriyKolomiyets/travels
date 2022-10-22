ALTER TABLE trip DROP COLUMN weatherDtoList;
ALTER TABLE trip ADD COLUMN weather_dto_list jsonb;
