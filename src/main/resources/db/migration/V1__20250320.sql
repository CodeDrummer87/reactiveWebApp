CREATE TABLE IF NOT EXISTS notifications(
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT now() NOT NULL,
    modified_at TIMESTAMP,
    expiration_date TIMESTAMP,
    message TEXT NOT NULL,
    message_type TEXT,
    user_uid VARCHAR(36),
    notification_status VARCHAR(32)
);