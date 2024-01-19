create table notifications
(
    id                        serial
        primary key,
    created_at                timestamp default now() not null,
    modified_at               timestamp,
    expiration_date           timestamp               not null,
    message                   text                    not null,
    error                     text,
    user_uid                  varchar(36),
    notification_status       varchar(32),
    message_type              varchar(32),
    trigger_code              varchar(128),
    object_type               varchar(255),
    object_id                 varchar(36),
    subject                   varchar(128),
    created_by                varchar(255),
    has_confirm_otp           boolean   default false,
    suggest_to_add_to_trusted boolean   default true,
    constraint notification_user_uid_status_type_trigger_code_idx
        unique (object_id, notification_status, message_type, trigger_code)
);

create index notifications_user_uid_trigger_code_object_id_object_type_idx
    on notifications (user_uid, trigger_code, object_id, object_type);