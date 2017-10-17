/*
 * Copyright 2017 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.kythe.util;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.html.types.SafeHtml;
import com.google.common.html.types.SafeUrl;
import com.google.common.html.types.SafeUrls;
import com.google.devtools.kythe.proto.MarkedSource;
import com.google.protobuf.TextFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import junit.framework.TestCase;

public class MarkedSourceRendererTest extends TestCase {
  private static final Path TEST_DATA_DIR =
      Paths.get("kythe/javatests/com/google/devtools/kythe/util/testdata/");
  private static final Function<String, SafeUrl> makeLink = inTicket -> SafeUrls.sanitize(inTicket);

  public void testRendering() throws IOException {
    MarkedSource.Builder input = MarkedSource.newBuilder();
    try (BufferedReader reader =
        Files.newBufferedReader(TEST_DATA_DIR.resolve("marked_source_renderer_test.textproto"))) {
      TextFormat.merge(reader, input);
    }
    MarkedSource markedSource = input.build();
    assertThat(
            MarkedSourceRenderer.renderSimpleQualifiedName(makeLink, markedSource, false)
                .getSafeHtmlString())
        .isEqualTo("<span>namespace::(anonymous namespace)::ClassContainer</span>");
    assertThat(
            MarkedSourceRenderer.renderSimpleQualifiedName(makeLink, markedSource, true)
                .getSafeHtmlString())
        .isEqualTo("<span>namespace::(anonymous namespace)::ClassContainer::FunctionName</span>");
    assertThat(
            MarkedSourceRenderer.renderSimpleIdentifier(makeLink, markedSource).getSafeHtmlString())
        .isEqualTo("<span>FunctionName</span>");
    List<SafeHtml> params = MarkedSourceRenderer.renderSimpleParams(makeLink, markedSource);
    assertThat(params.size()).isEqualTo(2);
    assertThat(params.get(0).getSafeHtmlString()).isEqualTo("<span>param_name_one</span>");
    assertThat(params.get(1).getSafeHtmlString()).isEqualTo("<span>param_name_two</span>");
  }
}
