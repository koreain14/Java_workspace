select g.title, m.title, movie_id, open_day, showtime from movie m, genre g where m.genre_id=g.genre_id

-- 湲곗〈 �뀒�씠釉� �닔�젙 ddl / dml / dcl

alter table movie 
add img varchar2(50);UPDATE movie
   SET img = 'movie_default.png'
 WHERE movie_id >= 12;

COMMIT;