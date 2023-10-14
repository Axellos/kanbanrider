CREATE TABLE IF NOT EXISTS agile_board_columns (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    agile_board_id BIGINT NOT NULL,
    name VARCHAR NOT NULL,
    type VARCHAR NOT NULL,
    "order" INT,
    is_resolved BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_agile_board FOREIGN KEY (agile_board_id) REFERENCES agile_boards(id)
);
