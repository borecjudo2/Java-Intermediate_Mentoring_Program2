package model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

  @Schema(description = "Event id", example = "1")
  private Integer id;

  @Schema(description = "Event title", example = "Main")
  private String title;

  @Schema(description = "Event place", example = "Minsk")
  private String place;

  @Schema(description = "Event speaker", example = "John Doe")
  private String speaker;

  @Schema(description = "Event type", example = "Spec")
  private String eventType;

  @Schema(description = "Event date time", pattern = "dd.MM.yyyy", example = "01.01.2021")
  private String dateTime;

}
