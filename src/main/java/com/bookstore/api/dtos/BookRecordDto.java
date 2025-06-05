package com.bookstore.api.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(
      UUID publisherId,
      Set<UUID> authorIds,
      String title,
      String reviewComment) {

}
