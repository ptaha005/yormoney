ALTER TABLE video ADD width bigint(20) FIRST;
ALTER TABLE video ADD height bigint(20) FIRST;

update video set width = 640,height = 480, url = '//www.youtube.com/embed/513kvQP_HMo'
