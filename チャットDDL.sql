-- Project Name : noname
-- Date/Time    : 2023/09/29 18:41:44
-- Author       : yamashita
-- RDBMS Type   : Oracle Database
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
*/

-- チャットリストテーブル
-- * RestoreFromTempTable
create table tb_chat_list (
  chatlist_id bigint(20) not null
  , room_id bigint(20)
  , create_d datetime
  , update_d datetime
  , constraint tb_chat_list_PKC primary key (chatlist_id)
) ;

-- チャットルームテーブル
-- * RestoreFromTempTable
create table tb_chat_rooms (
  chatroom_id bigint(20) not null
  , room_id bigint(20)
  , user_id bigint(20)
  , create_d datetime
  , update_d datetime
  , constraint tb_chat_rooms_PKC primary key (chatroom_id)
) ;

-- チャットユーザテーブル
-- * RestoreFromTempTable
create table tb_chatusers (
  userid int(11) auto_increment not null
  , nicname varchar(20) not null
  , password varchar(20) not null
  , repassword varchar(20) not null
  , createdate datetime not null
  , updatedate datetime not null
  , constraint tb_chatusers_PKC primary key (userid)
) ;

-- メッセージテーブル
-- * RestoreFromTempTable
create table tb_messeges (
  room_id bigint(20) not null
  , content varchar(100)
  , user_id bigint(20)
  , image longblob
  , create_d datetime
  , update_d datetime
  , constraint tb_messeges_PKC primary key (room_id)
) ;

comment on table tb_chat_list is 'チャットリストテーブル';
comment on column tb_chat_list.chatlist_id is 'chatlist_id';
comment on column tb_chat_list.room_id is 'room_id';
comment on column tb_chat_list.create_d is 'create_d';
comment on column tb_chat_list.update_d is 'update_d';

comment on table tb_chat_rooms is 'チャットルームテーブル';
comment on column tb_chat_rooms.chatroom_id is 'chatroom_id';
comment on column tb_chat_rooms.room_id is 'room_id';
comment on column tb_chat_rooms.user_id is 'user_id';
comment on column tb_chat_rooms.create_d is 'create_d';
comment on column tb_chat_rooms.update_d is 'update_d';

comment on table tb_chatusers is 'チャットユーザテーブル';
comment on column tb_chatusers.userid is 'userid';
comment on column tb_chatusers.nicname is 'nicname';
comment on column tb_chatusers.password is 'password';
comment on column tb_chatusers.repassword is 'repassword';
comment on column tb_chatusers.createdate is 'createdate';
comment on column tb_chatusers.updatedate is 'updatedate';

comment on table tb_messeges is 'メッセージテーブル';
comment on column tb_messeges.room_id is 'room_id';
comment on column tb_messeges.content is 'content';
comment on column tb_messeges.user_id is 'user_id';
comment on column tb_messeges.image is 'image';
comment on column tb_messeges.create_d is 'create_d';
comment on column tb_messeges.update_d is 'update_d';

