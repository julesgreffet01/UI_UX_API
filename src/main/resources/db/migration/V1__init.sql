CREATE TABLE `users`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email`      VARCHAR(255) NOT NULL,
    `password`   TEXT         NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE `projects`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`       VARCHAR(255) NOT NULL,
    `id_user`    BIGINT       NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE `todo_lists`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`       VARCHAR(255) NOT NULL,
    `id_project` BIGINT       NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE `todo_tasks`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `label`      VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `id_list`    BIGINT       NOT NULL
);
CREATE TABLE `gantt_boards`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`       VARCHAR(255) NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `id_project` BIGINT       NOT NULL
);
CREATE TABLE `gantt_activity`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `label`      VARCHAR(255) NOT NULL,
    `start_date` TIMESTAMP,
    `end_date`   TIMESTAMP,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `id_board`   BIGINT       NOT NULL
);
ALTER TABLE
    `todo_tasks`
    ADD CONSTRAINT `todo_tasks_id_list_foreign` FOREIGN KEY (`id_list`) REFERENCES `todo_lists` (`id`);
ALTER TABLE
    `gantt_boards`
    ADD CONSTRAINT `gantt_boards_id_project_foreign` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id`);
ALTER TABLE
    `gantt_activity`
    ADD CONSTRAINT `gantt_activity_id_board_foreign` FOREIGN KEY (`id_board`) REFERENCES `gantt_boards` (`id`);
ALTER TABLE
    `todo_lists`
    ADD CONSTRAINT `todo_lists_id_project_foreign` FOREIGN KEY (`id_project`) REFERENCES `projects` (`id`);
ALTER TABLE
    `projects`
    ADD CONSTRAINT `projects_id_user_foreign` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);