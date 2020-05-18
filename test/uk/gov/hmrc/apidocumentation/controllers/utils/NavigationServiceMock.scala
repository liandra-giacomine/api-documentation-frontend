/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.apidocumentation.controllers.utils

import org.mockito.Mockito.when
import org.mockito.Matchers.any
import org.scalatestplus.mockito.MockitoSugar
import uk.gov.hmrc.apidocumentation.models._
import uk.gov.hmrc.http.HeaderCarrier
import scala.concurrent.Future.successful

trait NavigationServiceMock extends MockitoSugar {
  import NavigationServiceMock._

  import uk.gov.hmrc.apidocumentation.services.NavigationService
  val navigationService = mock[NavigationService]
  when(navigationService.headerNavigation()(any[HeaderCarrier])).thenReturn(successful(Seq(navLink)))
  when(navigationService.sidebarNavigation()).thenReturn(Seq(sidebarLink))
  when(navigationService.apiSidebarNavigation(any(), any(), any())).thenReturn(Seq(sidebarLink))
}

object NavigationServiceMock {
  lazy val navLink = NavLink("Header Link", "/api-documentation/headerlink")
  lazy val sidebarLink = SidebarLink("API Documentation", "/api-documentation/docs/api")
}
