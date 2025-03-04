resolvers += "HMRC-open-artefacts-maven" at "https://open.artefacts.tax.service.gov.uk/maven2"
resolvers += Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns)

addSbtPlugin("uk.gov.hmrc"          %  "sbt-auto-build"           % "3.5.0")
addSbtPlugin("uk.gov.hmrc"          %  "sbt-distributables"       % "2.1.0")
addSbtPlugin("com.typesafe.play"    %  "sbt-plugin"               % "2.8.7")
addSbtPlugin("org.scoverage"        %  "sbt-scoverage"            % "1.6.1")
addSbtPlugin("org.irundaia.sbt"     %  "sbt-sassify"              % "1.4.13")
addSbtPlugin("net.ground5hark.sbt"  %  "sbt-concat"               % "0.2.0")
addSbtPlugin("com.typesafe.sbt"     %  "sbt-uglify"               % "2.0.0")
addSbtPlugin("com.typesafe.sbt"     %  "sbt-digest"               % "1.1.4")
addSbtPlugin("org.scalastyle"       %% "scalastyle-sbt-plugin"    % "1.0.0")
addSbtPlugin("ch.epfl.scala"        %  "sbt-bloop"                % "1.4.13")

