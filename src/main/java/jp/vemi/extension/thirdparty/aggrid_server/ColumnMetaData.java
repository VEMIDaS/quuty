/*
 * Copyright(c) 2022 vemi.
 */

package jp.vemi.extension.thirdparty.aggrid_server;

@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Data
@lombok.Builder
public class ColumnMetaData {

  Enum<?> field;

  String headerName;

  String cellEditor;

  @lombok.Builder.Default
  Boolean cellEditorPopup = false;

  CellRendererParams cellRendererParams;

  CellEditorParams cellEditorParams;

  @lombok.Builder.Default
  Integer width = 120;

  @lombok.Builder.Default
  Boolean rowDrag = false;

  @lombok.Builder.Default
  Boolean checkboxSelection = false;

  @lombok.Builder.Default
  Boolean headerCheckboxSelection = false;

  @lombok.Builder.Default
  Boolean headerCheckboxSelectionFilteredOnly = false;

}
