/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.apidocumentation.connectors

import javax.inject.{Inject, Singleton}
import uk.gov.hmrc.apidocumentation.config.ApplicationConfig
import uk.gov.hmrc.apidocumentation.models.{Session, SessionInvalid}
import uk.gov.hmrc.apidocumentation.models.JsonFormatters._
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.http.HttpClient
import uk.gov.hmrc.http.HttpReads.Implicits._

import scala.concurrent.{ExecutionContext, Future}
import uk.gov.hmrc.play.http.metrics.common._

@Singleton
class UserSessionConnector @Inject()(http: HttpClient, appConfig: ApplicationConfig, val apiMetrics: ApiMetrics)(implicit ec: ExecutionContext) extends RecordMetrics {

  val api = API("third-party-developer")
  private lazy val serviceBaseUrl: String = appConfig.thirdPartyDeveloperUrl

  def fetchSession(sessionId: String)(implicit hc: HeaderCarrier): Future[Session] = record {
    http.GET[Option[Session]](s"$serviceBaseUrl/session/$sessionId")
    .map {
      case Some(session) => session
      case None => throw new SessionInvalid
    }
  }
}
